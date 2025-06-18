package br.com.arquitetura.spring.jpa.proxies.services;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.Map;

@Service
public class GitHubFileUploadService {

    private final String USER;
    private final String REPO;
    private final String BRANCH;
    private final String TOKEN;

    private final WebClient webClient;

    public GitHubFileUploadService(Dotenv dotenv) {
        this.USER = dotenv.get("GITHUB_USER");
        this.REPO = dotenv.get("GITHUB_REPO");
        this.BRANCH = dotenv.get("GITHUB_BRANCH");
        this.TOKEN = dotenv.get("GITHUB_TOKEN");

        this.webClient = WebClient.builder()
                .baseUrl("https://api.github.com")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN)
                .build();
    }

    public String uploadFile(MultipartFile file, Integer dexNumber, Integer generation) throws Exception {
        String extension = getExtension(file.getOriginalFilename());
        String filename = dexNumber + "." + extension;
        String folder = "gen" + generation;
        String path = folder + "/" + filename;

        String apiUrl = "/repos/" + USER + "/" + REPO + "/contents/" + path;
        String base64Content = Base64.getEncoder().encodeToString(file.getBytes());

        Map<String, Object> body = Map.of(
                "message", "Upload " + filename,
                "content", base64Content,
                "branch", BRANCH
        );

        webClient.put()
                .uri(apiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return "https://raw.githubusercontent.com/" + USER + "/" + REPO + "/" + BRANCH + "/" + path;
    }

    private String getExtension(String filename) {
        String[] parts = filename.split("\\.");
        return parts.length > 1 ? parts[parts.length - 1] : "png";
    }
}
