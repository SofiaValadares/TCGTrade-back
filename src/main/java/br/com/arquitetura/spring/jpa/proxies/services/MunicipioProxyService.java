package br.com.arquitetura.spring.jpa.proxies.services;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceJsonProcessingRuntimeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;
import java.nio.charset.StandardCharsets;

@Service
public class MunicipioProxyService {

    //@Autowired
    private final WebClient webClient;

    public MunicipioProxyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://sistemas.tce.pe.gov.br").build();
    }

    public Mono<Map<String, Object>> getMunicipio(String municipio) {
        return this.webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/DadosAbertos/UnidadesJurisdicionadas!json")
                        .queryParam("NATUREZA", "prefeitura")
                        .queryParam("MUNICIPIO", municipio)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    byte[] bytes = response.getBytes(StandardCharsets.ISO_8859_1);
                    return new String(bytes, StandardCharsets.UTF_8);
                })
                .map(decodedJson -> {
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        return mapper.readValue(decodedJson, new TypeReference<Map<String, Object>>() {});
                    } catch (JsonProcessingException e) {
                        // Lança exceção dedicada com mensagem e causa
                        throw new ResourceJsonProcessingRuntimeException("Erro ao processar JSON do município: " + municipio, e);
                    }
                });
    }
}
