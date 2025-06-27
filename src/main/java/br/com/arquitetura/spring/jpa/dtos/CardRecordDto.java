package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.CardRarityEnum;
import br.com.arquitetura.spring.jpa.enums.CardTypeEnum;
import br.com.arquitetura.spring.jpa.enums.CardVariantEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CardRecordDto(
        @NotBlank String name,
        @NotNull Long idCollection,
        @NotNull Integer number,
        @NotNull CardTypeEnum type,
        String overrideRotationLetter,
        @NotNull CardRarityEnum rarity,
        @NotNull List<CardVariantEnum> variants,
        @NotBlank String imageUrl,
        Long idPokemon
) {
}