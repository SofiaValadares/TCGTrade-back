package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;

public record RoleResponseDto(
        Long idRole,
        RoleNameEnum roleName
) {
}
