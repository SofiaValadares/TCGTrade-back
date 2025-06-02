package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotNull;

public record SearchRecordDto(
        @NotNull String search
        ) {
}
