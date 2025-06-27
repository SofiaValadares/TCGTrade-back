package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.CardRarityEnum;
import br.com.arquitetura.spring.jpa.enums.CardVariantEnum;
import br.com.arquitetura.spring.jpa.enums.CardTypeEnum;

import java.util.List;

public record CardListResponseDto(
        Long idCard,
        String name,
        CollectionSummaryDto collection,
        Integer number,
        CardTypeEnum type,
        String rotationLetter,
        CardRarityEnum rarity,
        List<CardVariantEnum> variants,
        String imageUrl,
        PokemonSummaryDto pokemon
) {
}
