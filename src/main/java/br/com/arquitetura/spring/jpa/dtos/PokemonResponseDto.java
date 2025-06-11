package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;

import java.time.LocalDateTime;

public record PokemonResponseDto(
        Long idPokemon,
        String name,
        Integer numPokemon,
        PokemonTypeEnum primaryType,
        PokemonTypeEnum secondaryType,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {

}
