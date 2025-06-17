package br.com.arquitetura.spring.jpa.proxies.services;

import br.com.arquitetura.spring.jpa.dtos.GenerationResponseDto;
import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
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
                .uri("/pokemon-species/{pokemon}", pokemon) // 🔥 PRIMEIRA REQUISIÇÃO
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Map.class)
                .flatMap(speciesMap -> {
                    String name = speciesMap.get("name").toString();
                    Integer number = Integer.valueOf(speciesMap.get("id").toString());

                    Map<String, Object> generationMap = (Map<String, Object>) speciesMap.get("generation");
                    String generationUrl = generationMap.get("url").toString();


                    return this.webClient
                            .get()
                            .uri("/pokemon/{pokemon}", pokemon)
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToMono(Map.class)
                            .flatMap(pokemonMap -> {

                                String imageUrl = ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) pokemonMap.get("sprites")).get("other"))
                                        .get("official-artwork")).get("front_default").toString();


                                var typesList = (List<Map<String, Object>>) pokemonMap.get("types");
                                var type1Map = (Map<String, Object>) typesList.get(0).get("type");
                                var primaryType = PokemonTypeEnum.valueOf(type1Map.get("name").toString().toUpperCase());

                                PokemonTypeEnum secondaryType;

                                if (typesList.size() > 1) {
                                    var type2Map = (Map<String, Object>) typesList.get(1).get("type");
                                    secondaryType = PokemonTypeEnum.valueOf(type2Map.get("name").toString().toUpperCase());
                                } else {
                                    secondaryType = null;
                                }

                                // 🔥 Faz a última requisição para pegar o número da geração
                                return getGenerationNumberFromUrl(generationUrl)
                                        .map(generationNumber -> new PokemonResponseDto(
                                                null,
                                                name,
                                                number,
                                                generationNumber,
                                                primaryType,
                                                secondaryType,
                                                imageUrl,
                                                null,
                                                null,
                                                null,
                                                null
                                        ));
                            });
                });
    }


    public Mono<GenerationResponseDto> getGeneration(String generationNumber) {
        return this.webClient
                .get()
                .uri("/generation/{generationNumber}", generationNumber)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Map.class)
                .map(map -> {
                    Integer number = Integer.valueOf(map.get("id").toString());
                    String region = map.get("main_region") != null
                            ? ((Map<String, Object>) map.get("main_region")).get("name").toString()
                            : "unknown";

                    return new GenerationResponseDto(
                            null,
                            number,
                            region.toUpperCase(),
                            null,
                            null,
                            null,
                            null
                    );
                });
    }


    private Mono<Integer> getGenerationNumberFromUrl(String url) {
        return WebClient
                .create()
                .get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Map.class)
                .map(map -> Integer.valueOf(map.get("id").toString()));
    }









}