package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.CardLanguageEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CollectionRecordDto(
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String series,
        @NotNull CardLanguageEnum language,
        @NotNull @NotBlank String code,
        String ptcgoCode,
        @NotNull Date releaseDate,
        @NotNull Integer totalCards,
        @NotNull @NotBlank String symbolUrl,
        @NotNull @NotBlank String logoUrl,
        String defaultRotationLetter

) {
}

