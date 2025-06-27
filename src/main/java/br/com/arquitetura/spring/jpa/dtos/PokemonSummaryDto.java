package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;

public record PokemonSummaryDto(
    Long idPokemon,
    String name,
    Integer number
) {}
