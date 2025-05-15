package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    RoleModel saveRole(RoleModel roleModel);

    RoleModel updateRole(RoleModel roleModel);

    Optional<RoleModel> getRoleById(Long idRole);

    List<RoleModel> getAllRoles();

    Optional<RoleModel> getRoleByRoleName(RoleNameEnum roleName);

    void deleteRole(Long idRole);

}
