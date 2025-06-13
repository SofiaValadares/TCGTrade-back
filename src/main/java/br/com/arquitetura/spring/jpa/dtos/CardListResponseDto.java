package br.com.arquitetura.spring.jpa.dtos;

public record CardListResponseDto(
        Long idCard,
        String name,
        Long collection,
        Integer numberCard
) {
}
