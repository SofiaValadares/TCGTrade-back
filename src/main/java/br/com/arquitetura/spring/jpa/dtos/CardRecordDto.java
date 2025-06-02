package br.com.arquitetura.spring.jpa.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CardRecordDto(
        @NotBlank String nameCard,
        @NotNull Long collection,
        @NotNull Integer numberCard
) {
}
