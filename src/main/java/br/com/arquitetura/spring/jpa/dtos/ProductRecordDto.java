package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(
        @NotBlank(message = "Product name cannot be blank.") String name,
        @NotNull(message = "Product value cannot be null.") BigDecimal value) {
}
