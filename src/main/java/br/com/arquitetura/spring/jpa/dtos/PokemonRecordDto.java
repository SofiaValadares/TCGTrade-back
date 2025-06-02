package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record PokemonRecordDto(
        @NotNull Integer numPokemon,
        @NotBlank String name,
        @NotNull PokemonTypeEnum primaryType,
        PokemonTypeEnum secondaryType

) {
}