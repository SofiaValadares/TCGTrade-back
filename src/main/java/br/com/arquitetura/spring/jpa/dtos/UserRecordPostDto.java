package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.models.RoleModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserRecordPostDto(@NotBlank(message = "User name cannot be blank.") String name,
                                @NotBlank(message = "User email cannot be blank.") @Email(message = "User email cannot be invalid.") String email,
                                @NotBlank(message = "User username cannot be blank.") String username,
                                Boolean accountNonExpired,
                                Boolean accountNonLocked,
                                Boolean credentialsNonExpired,
                                Boolean enabled,
                                List<RoleModel> roles
) {
}