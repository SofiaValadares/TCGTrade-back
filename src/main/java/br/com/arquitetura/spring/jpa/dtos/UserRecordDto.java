package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.models.RoleModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import java.util.List;

public record UserRecordDto(
        @NotBlank(message = "User name cannot be blank.") String name,
        @NotBlank(message = "User email cannot be blank.") @Email(message = "User email cannot be invalid.") String email,
        @NotBlank(message = "User username cannot be blank.") String username,
        @NotBlank(message = "User password cannot be blank.") String password,
        Boolean accountNonExpired,
        Boolean accountNonLocked,
        Boolean credentialsNonExpired,
        Boolean enabled,
        List<RoleModel> roles
) {
}
