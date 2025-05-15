package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.UserRecordDto;
import br.com.arquitetura.spring.jpa.dtos.UserRecordPostDto;
import br.com.arquitetura.spring.jpa.dtos.UserRoleResponseDto;
import br.com.arquitetura.spring.jpa.dtos.UserResponseDto;
import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceFoundException;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.services.RoleService;
import br.com.arquitetura.spring.jpa.services.UserService;
import jakarta.persistence.criteria.Predicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private Root<UserModel> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private UserService userService;

    @Mock
    private RoleService roleService;

    @Mock
    private MessageSource messageSource;

    private Locale locale;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locale = Locale.getDefault();
    }

    @Test
    void testGetAllUsers() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        user.setName("John");
        user.setEmail("john@example.com");
        user.setUsername("john123");
        List<UserModel> userList = List.of(user);

        when(userService.getAllUsers()).thenReturn(userList);

        // When
        ResponseEntity<List<UserResponseDto>> response = userController.getAll();

        // Then
        Assertions.assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        assertEquals("john123", response.getBody().get(0).username());
    }

    @Test
    void testGetOneUser_UserFound() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        user.setName("John");
        user.setEmail("john@example.com");
        user.setUsername("john123");
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        // When
        ResponseEntity<UserRoleResponseDto> response = userController.getOneUser(1L, locale);

        // Then
        Assertions.assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("john123", Objects.requireNonNull(response.getBody()).username());
    }

    @Test
    void testGetOneUser_UserNotFound() {
        // Given
        when(userService.getUserById(1L)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.user.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Usuario não encontrado com o id 1");

        // When / Then
        assertThrows(ResourceNotFoundException.class, () -> {
            userController.getOneUser(1L, locale);
        });
    }

    @Test
    void testSaveUser_UserSavedSuccessfully() {
        // Given
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleName(RoleNameEnum.valueOf("ROLE_USER"));
        List<RoleModel> roles = List.of(roleModel);

        UserRecordDto userRecordDto = new UserRecordDto("John", "john@example.com", "john123", "senha123",
                true, true,true,true, roles);

        UserModel userModel = new UserModel();
        userModel.setIdUser(1L);
        userModel.setUsername("john123");

        // Mock do roleService para retornar o RoleModel ao buscar "ROLE_USER"
        when(roleService.getRoleByRoleName(RoleNameEnum.valueOf("ROLE_USER"))).thenReturn(Optional.of(roleModel));

        // Mock do userService para verificar se o username já existe e salvar o usuário
        when(userService.getUserByUsername("john123")).thenReturn(Optional.empty());
        when(userService.saveUser(any(UserModel.class))).thenReturn(userModel);

        // When
        ResponseEntity<UserRoleResponseDto> response = userController.saveUser(userRecordDto, locale);

        // Then
        Assertions.assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("john123", Objects.requireNonNull(response.getBody()).username());
    }

    @Test
    void testSaveUser_UserAlreadyExists() {
        // Given
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleName(RoleNameEnum.valueOf("ROLE_USER"));
        List<RoleModel> roles = List.of(roleModel);

        UserRecordDto userRecordDto = new UserRecordDto("John", "john@example.com", "john123","senha123",
                true, true,true,true, roles);
        UserModel userModel = new UserModel();
        userModel.setUsername("john123");

        when(userService.getUserByUsername("john123")).thenReturn(Optional.of(userModel));
        when(messageSource.getMessage(eq("error.user.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Usuario não encontrado com o id 1");

        // When / Then
        assertThrows(ResourceFoundException.class, () -> {
            userController.saveUser(userRecordDto, locale);
        });
    }

    @Test
    void testUpdateUser_UserUpdatedSuccessfully() {
        // Given
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleName(RoleNameEnum.valueOf("ROLE_USER"));
        List<RoleModel> roles = List.of(roleModel);

        UserRecordPostDto userRecordPostDto = new UserRecordPostDto("John", "john@example.com", "john123",
                true, true,true,true, roles);
        UserModel userModel = new UserModel();
        userModel.setIdUser(1L);
        userModel.setUsername("john123");

        // Mock do roleService para retornar o RoleModel ao buscar "ROLE_USER"
        when(roleService.getRoleByRoleName(RoleNameEnum.valueOf("ROLE_USER"))).thenReturn(Optional.of(roleModel));

        when(userService.getUserById(1L)).thenReturn(Optional.of(userModel));
        when(userService.updateUser(any(UserModel.class))).thenReturn(userModel);

        // When
        ResponseEntity<UserRoleResponseDto> response = userController.updateUser(1L, userRecordPostDto, locale);

        // Then
        Assertions.assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("john123", Objects.requireNonNull(response.getBody()).username());
    }

    @Test
    void testUpdateUser_UserNotFound() {
        // Given
        Long userId = 1L;
        UserRecordPostDto userRecordPostDto = new UserRecordPostDto("paul", "paul@example.com", "paul", true, true, true, true, List.of());
        when(userService.getUserById(userId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.user.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Usuario não encontrado com o id 1");

        // When & Then
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            userController.updateUser(userId, userRecordPostDto, locale);
        });

        // Verificamos se a exceção contém a mensagem correta
        assertEquals("Usuario não encontrado com o id " + userId, exception.getMessage());

        // Verificamos se o serviço foi chamado uma vez
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testDeleteUser_UserDeletedSuccessfully() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        // When
        ResponseEntity<Object> response = userController.deleteUser(1L, locale);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testDeleteUser_UserNotFound() {
        // Given
        when(userService.getUserById(1L)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.user.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Usuario não encontrado com o id 1");

        // When / Then
        assertThrows(ResourceNotFoundException.class, () -> {
            userController.deleteUser(1L, locale);
        });
    }

    @Test
    void testGetAllPageUsers() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setUsername("john123");
        List<UserModel> userList = List.of(user);
        Page<UserModel> userPage = new PageImpl<>(userList);

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
        when(userService.getAllPageUser(any(Specification.class), eq(pageable))).thenReturn(userPage);

        // When
        Page<UserResponseDto> responsePage = userController.getAllPageUsers(0, 10, "id", "asc", null, null, null);

        // Then
        Assertions.assertNotNull(responsePage);
        assertEquals(1, responsePage.getTotalElements());
        assertEquals("john123", responsePage.getContent().get(0).username());

        // Verifica se o método do serviço foi chamado
        verify(userService, times(1)).getAllPageUser(any(Specification.class), eq(pageable));
    }

    @Test
    void testNameContains_Success() {
        // Arrange
        String name = "John";
        when(criteriaBuilder.like(root.get("name"), "%" + name + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<UserModel> spec = userController.nameContains(name);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        Assertions.assertNotNull(predicate);
    }

    @Test
    void testNameContains_NullOrEmpty() {
        // Act
        Specification<UserModel> specNull = userController.nameContains(null);
        Specification<UserModel> specEmpty = userController.nameContains("");

        // Assert
        Assertions.assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        Assertions.assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    void testEmailContains_Success() {
        // Arrange
        String email = "john@example.com";
        when(criteriaBuilder.like(root.get("email"), "%" + email + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<UserModel> spec = userController.emailContains(email);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        Assertions.assertNotNull(predicate);
    }

    @Test
    void testEmailContains_NullOrEmpty() {
        // Act
        Specification<UserModel> specNull = userController.emailContains(null);
        Specification<UserModel> specEmpty = userController.emailContains("");

        // Assert
        Assertions.assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        Assertions.assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    void testUserNameContains_Success() {
        // Arrange
        String username = "john";
        when(criteriaBuilder.like(root.get("username"), "%" + username + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<UserModel> spec = userController.userNameContains(username);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        Assertions.assertNotNull(predicate);
    }

    @Test
    void testUserNameContains_NullOrEmpty() {
        // Act
        Specification<UserModel> specNull = userController.userNameContains(null);
        Specification<UserModel> specEmpty = userController.userNameContains("");

        // Assert
        Assertions.assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        Assertions.assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }
}
