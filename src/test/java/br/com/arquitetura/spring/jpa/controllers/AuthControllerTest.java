package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.AuthChangePasswordRecordDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceBadCredentialsException;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceUnauthorizedException;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceUsernameNotFoundException;
import br.com.arquitetura.spring.jpa.models.AuthRequestModel;
import br.com.arquitetura.spring.jpa.models.InvalidTokenModel;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.repositories.InvalidTokenRepository;
import br.com.arquitetura.spring.jpa.services.UserDetailsServiceImpl;
import br.com.arquitetura.spring.jpa.services.UserService;
import br.com.arquitetura.spring.jpa.globals.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserService userService;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private InvalidTokenRepository invalidTokenRepository;

    @Mock
    private MessageSource messageSource;

    private Locale locale;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locale = Locale.getDefault();
    }

//    @Test
//    void testCreateAuthenticationToken_Success() throws Exception {
//        // Given
//        AuthRequestModel authRequest = new AuthRequestModel();
//        authRequest.setUsername("john");
//        authRequest.setPassword("password123");
//
//        UserDetails userDetails = mock(UserDetails.class);
//        when(userDetailsService.loadUserByUsername("john")).thenReturn(userDetails);
//        when(jwtUtil.generateToken(userDetails)).thenReturn("fake-jwt-token");
//
//        // Mock para autenticação com sucesso
//        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
//
//        // When
//        when(messageSource.getMessage(eq("error.user.username.notfound"), any(Object[].class), eq(locale)))
//                .thenReturn("Usuario não encontrado com o username");
//
//        ResponseEntity<?> response = authController.createAuthenticationToken(authRequest, locale);
//
//        // Then
//        assertNotNull(response);
//        assertEquals(200, response.getStatusCode().value());
//        AuthResponseModel authResponse = (AuthResponseModel) response.getBody();
//        assert authResponse != null;
//        assertEquals("fake-jwt-token", authResponse.getJwt());
//    }

    @Test
    void testCreateAuthenticationToken_InvalidCredentials() throws Exception {
        // Given
        AuthRequestModel authRequest = new AuthRequestModel();
        authRequest.setUsername("john");
        authRequest.setPassword("wrongpassword");

        // Mock para credenciais inválidas
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("Invalid credentials"));
        when(messageSource.getMessage(eq("error.user.loginpassword.invalidcredential"), any(Object[].class), eq(locale)))
                .thenReturn("Credencias invalida: user.");

        // When / Then
        ResourceUnauthorizedException exception = assertThrows(ResourceUnauthorizedException.class, () -> {
            authController.createAuthenticationToken(authRequest, locale);
        });

        assertEquals("Credencias invalida: user.", exception.getMessage());
    }

    // Teste do logout (logoutUser)
    @Test
    void testLogoutUser_Success() {
        // Given
        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer fake-jwt-token");

        // When
        ResponseEntity<?> response = authController.logoutUser(httpServletRequest);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        Map<String, String> body = (Map<String, String>) response.getBody();
        assertEquals("Logout successful", body.get("message"));

        // Verifica que o save foi chamado
        verify(invalidTokenRepository, times(1)).save(any(InvalidTokenModel.class));
    }

    // Teste de troca de senha (changePassword)
    @Test
    void testChangePassword_Success() {
        // Given
        AuthChangePasswordRecordDto changePasswordDto = new AuthChangePasswordRecordDto("oldPassword", "newPassword");
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("john");

        UserModel user = new UserModel();
        user.setPassword("encodedOldPassword");


        // Mock para buscar o usuário pelo nome de usuário
        when(userService.getUserByUsername("john")).thenReturn(Optional.of(user));
        // Mock para verificar se a senha antiga está correta
        when(passwordEncoder.matches("oldPassword", user.getPassword())).thenReturn(true);

        // When
        ResponseEntity<?> response = authController.changePassword(changePasswordDto, locale);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Password changed successfully!", response.getBody());

        // Verifica se a nova senha foi setada e o usuário foi salvo
        verify(userService, times(1)).saveUser(user);
        assertEquals("newPassword", user.getPassword());
    }

    @Test
    void testChangePassword_UserNotFound() {
        // Given
        AuthChangePasswordRecordDto changePasswordDto = new AuthChangePasswordRecordDto("oldPassword", "newPassword");
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("nonexistentUser");

        // Simular que o usuário não foi encontrado
        when(userService.getUserByUsername("nonexistentUser")).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.user.username.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Usuario não encontrado com o username");

        // When & Then
        ResourceUsernameNotFoundException exception = assertThrows(ResourceUsernameNotFoundException.class, () -> {
            authController.changePassword(changePasswordDto, locale);
        });

        // Verifica se a exceção contém a mensagem correta
        assertEquals("Usuario não encontrado com o username", exception.getMessage());

        // Verifica se o método userService.getUserByUsername foi chamado
        verify(userService, times(1)).getUserByUsername("nonexistentUser");
    }

    @Test
    void testChangePassword_InvalidOldPassword() {
        // Given
        AuthChangePasswordRecordDto changePasswordDto = new AuthChangePasswordRecordDto("wrongOldPassword", "newPassword");
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("john");
        UserModel user = new UserModel();
        user.setPassword("encodedOldPassword");

        // Mock para buscar o usuário pelo nome de usuário
        when(userService.getUserByUsername("john")).thenReturn(Optional.of(user));
        // Mock para verificar se a senha antiga está incorreta
        when(passwordEncoder.matches("wrongOldPassword", user.getPassword())).thenReturn(false);
        when(messageSource.getMessage(eq("error.credentials.bad.old.pass"), any(Object[].class), eq(locale)))
                .thenReturn("Senha antiga não confere.");

        // When / Then
        ResourceBadCredentialsException exception = assertThrows(ResourceBadCredentialsException.class, () -> {
            authController.changePassword(changePasswordDto, locale);
        });

        assertEquals("Senha antiga não confere.", exception.getMessage());
    }
}
