package br.com.arquitetura.spring.jpa.dtos;

import java.time.LocalDateTime;

public record GenerationResponseDto(
        Long idGeneration,
        Integer number,
        String region,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {
}
