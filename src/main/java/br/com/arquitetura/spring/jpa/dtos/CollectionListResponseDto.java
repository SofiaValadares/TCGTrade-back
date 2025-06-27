package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.CardLanguageEnum;

import java.util.Date;
import java.util.List;

public record CollectionListResponseDto(
        Long idCollection,
        String name,
        String series,
        CardLanguageEnum language,
        String code,
        String ptcgoCode,
        Date releaseDate,
        Integer totalCards,
        String symbolUrl,
        String logoUrl,
        String defaultRotationLetter,
        List<CardListResponseDto> cards
) {
}
