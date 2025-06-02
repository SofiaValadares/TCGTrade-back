package br.com.arquitetura.spring.jpa.proxies.controllers;

import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.proxies.services.PokeApiProxyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("api/proxy")
public class PokeApiProxyController {

    private final PokeApiProxyService pokeApiProxyService;

    public PokeApiProxyController(PokeApiProxyService pokeApiProxyService) {
        this.pokeApiProxyService = pokeApiProxyService;
    }

//    @GetMapping("/pokemon")
//    public Mono<ResponseEntity<PokemonResponseDto>> getDadosPokemon(@RequestParam String pokemon) {
//        return pokeApiProxyService.getPokemon(pokemon)
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.status(404).build());
//    }
}
