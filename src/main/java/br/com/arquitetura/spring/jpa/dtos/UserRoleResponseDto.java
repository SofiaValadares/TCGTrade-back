package br.com.arquitetura.spring.jpa.dtos;

import br.com.arquitetura.spring.jpa.models.RoleModel;
import java.util.List;

public record UserRoleResponseDto(
        Long idUser,
        String name,
        String email,
        String username,
        Boolean accountNonExpired,
        Boolean accountNonLocked,
        Boolean credentialsNonExpired,
        Boolean enabled,
        List<RoleModel> roles
) {
}
