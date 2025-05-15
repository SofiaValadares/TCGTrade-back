package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.globals.validation.ValueOfEnum;
import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;
import jakarta.validation.constraints.NotNull;

public record RoleRecordDto(
        @NotNull(message = "Role name cannot be blank.")
        @ValueOfEnum(enumClass = RoleNameEnum.class) RoleNameEnum roleName
        // @ValidEnum(enumClass = RoleNameEnum.class, message = "Invalid role name.") RoleNameEnum roleName

) {
}
