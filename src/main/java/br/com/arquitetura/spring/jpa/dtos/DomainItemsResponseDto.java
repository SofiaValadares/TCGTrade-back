package br.com.arquitetura.spring.jpa.dtos;

import java.time.LocalDateTime;

public record DomainItemsResponseDto(
        Long idDomainItems,
        Long idDomain,
        String codDomainItems,
        String name,
        Boolean enabled,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {
}
