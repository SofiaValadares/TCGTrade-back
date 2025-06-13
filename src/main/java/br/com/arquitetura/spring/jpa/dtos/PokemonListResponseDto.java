package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;

import java.util.List;

public record PokemonListResponseDto(
        Long idPokemon,
        String name,
        Integer numPokemon,
        PokemonTypeEnum primaryType,
        PokemonTypeEnum secondaryType,
        List<CardListResponseDto> cards
) {
}
