package br.com.arquitetura.spring.jpa.proxies.controllers;

import br.com.arquitetura.spring.jpa.proxies.services.GitHubFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/proxy/github")
public class GitHubFileUploadController {

    @Autowired
    private GitHubFileUploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("dexNumber") Integer dexNumber,
            @RequestParam("generation") Integer generation) {
        try {
            String fileUrl = uploadService.uploadFile(file, dexNumber, generation);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
    }
}
