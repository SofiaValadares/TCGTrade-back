package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;

public record PokemonResponseDto(
        Long idPokemon,
        String name,
        Integer numPokemon,
        PokemonTypeEnum primaryType,
        PokemonTypeEnum secondaryType
) {

}
