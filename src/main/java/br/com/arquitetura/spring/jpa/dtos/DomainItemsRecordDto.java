package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DomainItemsRecordDto(
        @NotNull(message = "Domain id cannot be null.") Long idDomain,
        @NotNull(message = "Domain Items cod cannot be null.") @NotBlank(message = "Domain Items cod cannot be blank.") String codDomainItems,
        @NotNull(message = "Domain Items name cannot be null.") @NotBlank(message = "Domain Items name cannot be blank.") String name,
        Boolean enabled
) {
}
