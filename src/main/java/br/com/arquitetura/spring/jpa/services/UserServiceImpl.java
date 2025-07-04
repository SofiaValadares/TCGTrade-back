package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;
import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.repositories.RoleRepository;
import br.com.arquitetura.spring.jpa.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        RoleModel defaultRole = roleRepository.findByRoleName(RoleNameEnum.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role ROLE_USER não encontrada no banco"));

        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setRoles(Set.of(defaultRole));
        return userRepository.save(userModel);
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public Optional<UserModel> getUserById(Long idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public Page<UserModel> getAllPageUser(Specification<UserModel> spec, Pageable pageable) {
        return userRepository.findAll(spec, pageable);
    }
}
