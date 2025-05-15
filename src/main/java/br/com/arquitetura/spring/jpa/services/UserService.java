package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserModel saveUser(UserModel userModel);

    UserModel updateUser(UserModel userModel);

    Optional<UserModel> getUserById(Long idUser);

    List<UserModel> getAllUsers();

    Optional<UserModel> getUserByUsername(String username);

    Optional<UserModel> getUserByEmail(String email);

    void deleteUser(Long idUser);

    Page<UserModel> getAllPageUser(Specification<UserModel> spec, Pageable pageable);
}
