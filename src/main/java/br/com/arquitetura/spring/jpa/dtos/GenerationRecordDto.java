package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GenerationRecordDto(
        @NotNull Integer number,
        @NotBlank String region
) {
}
