package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PokemonRecordDto(
        @NotNull Integer number,
        @NotBlank String name,
        @NotNull Integer generation,
        @NotNull PokemonTypeEnum primaryType,
        PokemonTypeEnum secondaryType,
        String imageUrl

) {
}