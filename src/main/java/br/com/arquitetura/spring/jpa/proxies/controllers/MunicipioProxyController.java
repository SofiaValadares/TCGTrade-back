package br.com.arquitetura.spring.jpa.proxies.controllers;

import br.com.arquitetura.spring.jpa.proxies.services.MunicipioProxyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/proxy")
public class MunicipioProxyController {

    private final MunicipioProxyService municipioProxyService;

    public MunicipioProxyController(
            MunicipioProxyService proxyService)
    {
        this.municipioProxyService = proxyService;
    }

    @GetMapping("/municipios")
    public Mono<ResponseEntity<Map<String, Object>>> getDadosMunicipio(@RequestParam String municipio) {
        return municipioProxyService.getMunicipio(municipio)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(404).build());
    }
}
