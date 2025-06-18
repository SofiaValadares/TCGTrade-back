package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.*;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceFoundException;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.services.UserService;
import br.com.arquitetura.spring.jpa.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.Locale;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    private static final String ERROR_USER_ID_NOTFOUND = "error.user.id.notfound";

    private final UserService userService;
    private final RoleService roleService;
    private final MessageSource messageSource;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(
            UserService userService,
            RoleService roleService,
            MessageSource messageSource,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.userService = userService;
        this.roleService = roleService;
        this.messageSource = messageSource;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<UserModel> userList = userService.getAllUsers();
        List<UserResponseDto> responseList = userList.stream()
                .map(this::mapToUserResponseDto)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserRoleResponseDto> getOneUser(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<UserModel> userOptional = userService.getUserById(id);
        if (userOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_USER_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToUserRoleResponseDto(userOptional.get()));
    }

    @PostMapping("/users")
    public ResponseEntity<UserRoleResponseDto> saveUser(@RequestBody @Valid UserRecordDto userRecordDto, Locale locale) {
        var userModel = new UserModel();

        Optional<UserModel> userOptional = userService.getUserByUsername(userRecordDto.username());
        if (userOptional.isPresent()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.user.loginpassword.notfound",
                    new Object[]{userRecordDto.username()},
                    locale
            );
        }

        BeanUtils.copyProperties(userRecordDto, userModel, "roles");

        if (userModel.getAccountNonExpired() == null) userModel.setAccountNonExpired(true);
        if (userModel.getAccountNonLocked() == null) userModel.setAccountNonLocked(true);
        if (userModel.getCredentialsNonExpired() == null) userModel.setCredentialsNonExpired(true);
        if (userModel.getEnabled() == null) userModel.setEnabled(true);

        Set<RoleModel> roles = userRecordDto.roles().stream()
                .map(roleRequest -> roleService.getRoleByRoleName(roleRequest.getRoleName())
                        .orElseThrow(() -> ResourceNotFoundException.withMessage(
                                messageSource, "error.role.name.notfound",
                                new Object[]{roleRequest.getRoleName()},
                                locale
                        )))
                .collect(Collectors.toSet());

        userModel.setRoles(roles);
        UserModel saveUser = userService.saveUser(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToUserRoleResponseDto(saveUser));
    }

    @PostMapping("/activate")
    public ResponseEntity<UserRoleResponseDto> activateUser(@RequestBody @Valid ActivateRecordDto activateRecordDto, Locale locale) {

        //verifica user
        Optional<UserModel> userOptional = userService.getUserByUsername(activateRecordDto.cpf());
        if (userOptional.isEmpty()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.user.loginpassword.notfound",
                    new Object[]{activateRecordDto.cpf()},
                    locale
            );
        }

        // Se achou o usuario inicia as mudan
        userOptional.get().setEnabled(true);
        userOptional.get().setEmail(activateRecordDto.email());
        userOptional.get().setTelefone(activateRecordDto.telefone());
        userOptional.get().setPassword(passwordEncoder.encode(activateRecordDto.senha()));

        //atualiza no banco
        UserModel updatedUser = userService.updateUser(userOptional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToUserRoleResponseDto(updatedUser));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserRoleResponseDto> updateUser(@PathVariable(value = "id") Long id,
                                                          @RequestBody @Valid UserRecordPostDto userRecordPostDto, Locale locale) {
        Optional<UserModel> userOptional = userService.getUserById(id);
        if (userOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_USER_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        var userModel = userOptional.get();
        BeanUtils.copyProperties(userRecordPostDto, userModel, "roles");

        userModel.setAccountNonExpired(userRecordPostDto.accountNonExpired());
        userModel.setAccountNonLocked(userRecordPostDto.accountNonLocked());
        userModel.setCredentialsNonExpired(userRecordPostDto.credentialsNonExpired());
        userModel.setEnabled(userRecordPostDto.enabled());

        Set<RoleModel> roles = userRecordPostDto.roles().stream()
                .map(roleRequest -> roleService.getRoleByRoleName(roleRequest.getRoleName())
                        .orElseThrow(() -> ResourceNotFoundException.withMessage(
                                messageSource, "error.role.name.notfound",
                                new Object[]{roleRequest.getRoleName()},
                                locale
                        )))
                .collect(Collectors.toSet());

        userModel.setRoles(roles);
        UserModel updateUser = userService.updateUser(userModel);

        return ResponseEntity.status(HttpStatus.OK).body(mapToUserRoleResponseDto(updateUser));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<UserModel> userOptional = userService.getUserById(id);
        if (userOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_USER_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        userService.deleteUser(userOptional.get().getIdUser());

        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/users/me")
    public ResponseEntity<UserRoleResponseDto> getCurrentUser(Authentication authentication) {
        org.springframework.security.core.userdetails.User userDetails =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        String username = userDetails.getUsername();

        UserModel user = userService.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(mapToUserRoleResponseDto(user));
    }


    @GetMapping("/users/page")
    public Page<UserResponseDto> getAllPageUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String username) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Specification<UserModel> spec = Specification.where(nameContains(name)).and(emailContains(email)).and(userNameContains(username));
        Page<UserModel> userPage = userService.getAllPageUser(spec, pageable);

        return userPage.map(this::mapToUserResponseDto);
    }

    Specification<UserModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    Specification<UserModel> emailContains(String email) {
        return (root, query, criteriaBuilder) -> {
            if (email == null || email.isEmpty()) return null;
            return criteriaBuilder.like(root.get("email"), "%" + email + "%");
        };
    }

    Specification<UserModel> userNameContains(String username) {
        return (root, query, criteriaBuilder) -> {
            if (username == null || username.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + username + "%");
        };
    }

    private UserResponseDto mapToUserResponseDto(UserModel userModel) {
        return new UserResponseDto(
                userModel.getIdUser(),
                userModel.getName(),
                userModel.getEmail(),
                userModel.getUsername(),
                userModel.getAccountNonExpired(),
                userModel.getAccountNonLocked(),
                userModel.getCredentialsNonExpired(),
                userModel.getEnabled(),
                userModel.getTelefone()
        );
    }

    private UserRoleResponseDto mapToUserRoleResponseDto(UserModel userModel) {
        List<RoleModel> roles = (userModel.getAuthorities() == null)
                ? List.of()
                : userModel.getAuthorities().stream()
                .map(RoleModel.class::cast)
                .toList();

        return new UserRoleResponseDto(
                userModel.getIdUser(),
                userModel.getName(),
                userModel.getEmail(),
                userModel.getUsername(),
                userModel.getAccountNonExpired(),
                userModel.getAccountNonLocked(),
                userModel.getCredentialsNonExpired(),
                userModel.getEnabled(),
                roles
        );
    }
}
