package br.com.arquitetura.spring.jpa.dtos;

import java.time.LocalDateTime;

public record DomainResponseDto(
        Long idDomain,
        String name,
        String description,
        Boolean enabled,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {
}
