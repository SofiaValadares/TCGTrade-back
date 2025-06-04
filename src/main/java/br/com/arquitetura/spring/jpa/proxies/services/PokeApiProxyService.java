package br.com.arquitetura.spring.jpa.proxies.services;

import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
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

    public Mono<PokemonResponseDto> getPokemon(String pokemon) {
        return this.webClient
                .get()
                .uri("/pokemon/{pokemon}", pokemon)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Map.class)
                .map(map -> {
                    Long id = Long.valueOf(map.get("id").toString());

                    Map<String, Object> speciesMap = (Map<String, Object>) map.get("species");
                    String name = speciesMap.get("name").toString();

                    Integer numPokemon = Integer.valueOf(map.get("id").toString());

                    var typesList = (java.util.List<Map<String, Object>>) map.get("types");


                    var type1Map = (Map<String, Object>) typesList.get(0).get("type");
                    var primaryType = PokemonTypeEnum.valueOf(type1Map.get("name").toString().toUpperCase());


                    PokemonTypeEnum secondaryType = null;
                    if (typesList.size() > 1) {
                        var type2Map = (Map<String, Object>) typesList.get(1).get("type");
                        secondaryType = PokemonTypeEnum.valueOf(type2Map.get("name").toString().toUpperCase());
                    }

                    return new PokemonResponseDto(id, name, numPokemon, primaryType, secondaryType);
                });
    }



}