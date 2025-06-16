package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;

import java.util.List;

public record PokemonListResponseDto(
        Long idPokemon,
        String name,
        Integer number,
        Integer generation,
        PokemonTypeEnum primaryType,
        PokemonTypeEnum secondaryType,
        String imageUrl,
        List<CardListResponseDto> cards
) {
}
