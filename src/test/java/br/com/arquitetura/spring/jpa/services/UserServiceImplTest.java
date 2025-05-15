package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;

import static br.com.arquitetura.spring.jpa.enums.RoleNameEnum.ROLE_USER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Given
        UserModel user1 = new UserModel();
        user1.setIdUser(1L);
        user1.setName("User 1");

        UserModel user2 = new UserModel();
        user2.setIdUser(2L);
        user2.setName("User 2");

        List<UserModel> userList = List.of(user1, user2);
        when(userRepository.findAll()).thenReturn(userList);

        // When
        List<UserModel> result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("User 1", result.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetOneUser_Found() {
        // Given
        Long id = 1L;
        UserModel user = new UserModel();
        user.setIdUser(id);
        user.setName("Test User");


        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // When
        Optional<UserModel> result = userService.getUserById(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Test User", result.get().getName());
        verify(userRepository, times(1)).findById(id);
    }

    @Test
    void testGetOneUser_NotFound() {
        // Given
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<UserModel> result = userService.getUserById(id);

        // Then
        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findById(id);
    }


    @Test
    void testSaveUser() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        user.setName("User");
        user.setUsername("User 1");
        user.setPassword(passwordEncoder.encode("teste123"));

        when(userRepository.save(user)).thenReturn(user);

        // When
        UserModel result = userService.saveUser(user);

        // Then
        assertNotNull(result);
        assertEquals("User", result.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testUpdateUser() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        user.setName("User 1");

        when(userRepository.save(user)).thenReturn(user);

        // When
        UserModel result = userService.updateUser(user);

        // Then
        assertNotNull(result);
        assertEquals("User 1", result.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        // Given
        Long userId = 1L;

        // When
        userService.deleteUser(userId);

        // Then
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testGetUserByUsername_Found() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        user.setUsername("User");
        user.setEmail("user@exemplo.com");
        user.setPassword(passwordEncoder.encode("teste123"));

        when(userRepository.findByUsername("User")).thenReturn(Optional.of(user));

        // When
        Optional<UserModel> result = userService.getUserByUsername("User");

        // Then
        assertTrue(result.isPresent());
        assertEquals("User", result.get().getUsername());
        verify(userRepository, times(1)).findByUsername("User");
    }

    @Test
    void testGetUserByUsername_NotFound() {
        // Given
        String username = "User";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // When
        Optional<UserModel> result = userService.getUserByUsername(username);

        // Then
        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findByUsername(username);
    }


    @Test
    void testGetUserByEmail_Found() {
        // Given
        UserModel user = new UserModel();
        user.setIdUser(1L);
        user.setUsername("User");
        user.setEmail("user@exemplo.com");
        user.setPassword(passwordEncoder.encode("teste123"));

        when(userRepository.findByEmail("user@exemplo.com")).thenReturn(Optional.of(user));

        // When
        Optional<UserModel> result = userService.getUserByEmail("user@exemplo.com");

        // Then
        assertTrue(result.isPresent());
        assertEquals("user@exemplo.com", result.get().getEmail());
        verify(userRepository, times(1)).findByEmail("user@exemplo.com");
    }

    @Test
    void testGetUserByEmail_NotFound() {
        // Given
        String email = "user@exemplo.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // When
        Optional<UserModel> result = userService.getUserByEmail(email);

        // Then
        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    void testGetAllPageUsers() {
        // Given
        UserModel user1 = new UserModel();
        user1.setIdUser(1L);
        user1.setName("User 1");

        UserModel user2 = new UserModel();
        user2.setIdUser(2L);
        user2.setName("User 2");

        Page<UserModel> page = new PageImpl<>(Arrays.asList(user1, user2));

        Pageable pageable = PageRequest.of(0, 10);
        Specification<UserModel> spec = mock(Specification.class);

        when(userRepository.findAll(spec, pageable)).thenReturn(page);

        Page<UserModel> result = userService.getAllPageUser(spec, pageable);

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals("User 1", result.getContent().get(0).getName());
        assertEquals("User 2", result.getContent().get(1).getName());

        verify(userRepository, times(1)).findAll(spec, pageable);
    }
}
