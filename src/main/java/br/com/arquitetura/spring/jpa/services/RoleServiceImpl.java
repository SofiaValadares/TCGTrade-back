package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;
import br.com.arquitetura.spring.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleModel saveRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    @Override
    public RoleModel updateRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    @Override
    public Optional<RoleModel> getRoleById(Long idRole) {
        return roleRepository.findById(idRole);
    }

    @Override
    public List<RoleModel> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleModel> getRoleByRoleName(RoleNameEnum roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void deleteRole(Long idRole) {
        roleRepository.deleteById(idRole);
    }
}
