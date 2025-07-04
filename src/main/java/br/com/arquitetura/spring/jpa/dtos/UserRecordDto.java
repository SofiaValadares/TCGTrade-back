package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(
        @NotBlank(message = "User name cannot be blank.") String name,
        @NotBlank(message = "User username cannot be blank.") String username,
        @NotBlank(message = "User password cannot be blank.") String password
) {
}
