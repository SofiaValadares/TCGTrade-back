package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.CardLanguageEnum;

import java.time.LocalDateTime;
import java.util.Date;

public record CollectionResponseDto(
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
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {
}
