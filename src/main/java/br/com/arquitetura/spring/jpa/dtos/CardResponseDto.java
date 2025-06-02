package br.com.arquitetura.spring.jpa.dtos;

public record CardResponseDto (
        Long idCard,
        String name,
        Long collection,
        Integer numberCard
) {

}
