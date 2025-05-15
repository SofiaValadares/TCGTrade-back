package br.com.arquitetura.spring.jpa.dtos;

import java.util.List;

public record DomainListResponseDto(
        Long idDomain,
        String name,
        String description,
        Boolean enabled,
        List<DomainItemsListResponseDto> domainItems
) {
}
