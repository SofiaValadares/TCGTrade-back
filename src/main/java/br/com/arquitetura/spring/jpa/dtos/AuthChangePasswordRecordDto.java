package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthChangePasswordRecordDto(
        @NotNull(message = "oldPassword cannot be null.") @NotBlank(message = "oldPassword cannot be blank.") String oldPassword,
        @NotNull(message = "newPassword cannot be null.") @NotBlank(message = "newPassword cannot be blank.") String newPassword
) {
}
