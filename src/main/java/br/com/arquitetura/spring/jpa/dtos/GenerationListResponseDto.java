package br.com.arquitetura.spring.jpa.dtos;

import java.util.List;

public record GenerationListResponseDto (
        Long idGeneration,
        Integer number,
        String region,
        List<PokemonResponseDto> pokemons
) { }
