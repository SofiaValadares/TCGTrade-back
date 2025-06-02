package br.com.arquitetura.spring.jpa.proxies.services;

import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class PokeApiProxyService {
    private final WebClient webClient;

    public PokeApiProxyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://pokeapi.co/api/v2/")
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 1024))
                        .build())
                .build();
    }

//    public Mono<PokemonResponseDto> getPokemon(String pokemon) {
//        return this.webClient
//                .get()
//                .uri("/pokemon/{pokemon}", pokemon)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {
//                })
//                .map(map -> new PokemonResponseDto(
//                        Long.valueOf(map.get("id").toString()),
//                        map.get("name").toString(),
//                        Integer.valueOf(map.get("order").toString())
//                ));
//    }
}