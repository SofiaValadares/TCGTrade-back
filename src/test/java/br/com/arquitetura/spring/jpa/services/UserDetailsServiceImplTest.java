package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceUsernameNotFoundException;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MessageSource messageSource;

    private Locale locale;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locale = Locale.getDefault();
    }

    @Test
    void testLoadUserByUsername_UserFound() {
        // Given
        String username = "testUser";
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword("password");
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // When
        UserDetails result = userDetailsService.loadUserByUsername(username);

        // Then
        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertEquals("password", result.getPassword());
        assertTrue(result.isEnabled());
        assertTrue(result.isAccountNonExpired());
        assertTrue(result.isCredentialsNonExpired());
        assertTrue(result.isAccountNonLocked());
        verify(userRepository, times(1)).findByUsername(username);
    }

//    @Test
//    void testLoadUserByUsername_UserNotFound() {
//        // Given
//        String username = "nonexistentUser";
//
//        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
//        when(messageSource.getMessage(eq("error.user.username.notfound"), any(Object[].class), eq(locale)))
//                .thenReturn("Usuario não encontrado com o username: nonexistentUser");
//
//        // When & Then
//        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> {
//            userDetailsService.loadUserByUsername(username);
//        });
//
//        assertEquals("Usuario não encontrado com o username: " + username, exception.getMessage());
//        verify(userRepository, times(1)).findByUsername(username);
//    }
}
