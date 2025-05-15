package br.com.arquitetura.spring.jpa.dtos;

public record DomainItemsListResponseDto(
        Long idDomainItems,
        String codDomainItems,
        String name,
        Boolean enabled
) {
}
