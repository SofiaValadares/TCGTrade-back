package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DomainRecordDto(
        @NotBlank(message = "Domain name cannot be blank.") @NotNull(message = "Domain name cannot be null.") String name,
        String description,
        Boolean enabled
) {
}
