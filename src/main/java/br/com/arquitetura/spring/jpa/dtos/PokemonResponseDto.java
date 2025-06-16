package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;

import java.time.LocalDateTime;

public record PokemonResponseDto(
        Long idPokemon,
        String name,
        Integer number,
        Integer generation,
        PokemonTypeEnum primaryType,
        PokemonTypeEnum secondaryType,
        String imageUrl,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {

}
