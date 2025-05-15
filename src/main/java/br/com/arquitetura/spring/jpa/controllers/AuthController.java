package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.*;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.*;
import br.com.arquitetura.spring.jpa.models.*;
import br.com.arquitetura.spring.jpa.services.UserDetailsServiceImpl;
import br.com.arquitetura.spring.jpa.globals.security.JwtUtil;
import br.com.arquitetura.spring.jpa.services.UserService;
import br.com.arquitetura.spring.jpa.repositories.InvalidTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Locale;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    private static final String ERROR_USER_USERNAME_NOTFOUND = "error.user.username.notfound";

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserService userService;
    private final MessageSource messageSource;
    private final InvalidTokenRepository invalidTokenRepository;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil,
            BCryptPasswordEncoder passwordEncoder,
            UserDetailsServiceImpl userDetailsService,
            UserService userService,
            MessageSource messageSource,
            InvalidTokenRepository invalidTokenRepository) {

        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.messageSource = messageSource;
        this.invalidTokenRepository = invalidTokenRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> createAuthenticationToken(@RequestBody AuthRequestModel authRequestModel, Locale locale) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestModel.getUsername(), authRequestModel.getPassword())
            );
        } catch (AuthenticationException e) {
            throw ResourceUnauthorizedException.withMessage(
                    messageSource,"error.user.loginpassword.invalidcredential",
                    new Object[]{e.getMessage()},
                    locale
            );
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestModel.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        UserModel user = userService.getUserByUsername(authRequestModel.getUsername()).orElseThrow(() ->
                ResourceUsernameNotFoundException.withMessage(
                        messageSource,ERROR_USER_USERNAME_NOTFOUND,
                        new Object[]{authRequestModel.getUsername()},
                        locale
                )
        );

        return ResponseEntity.ok(mapToAuthResponseDto(token, Boolean.TRUE, user));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logoutUser(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            // Adiciona o token à lista de inválidos com expiração de 1 dia
            InvalidTokenModel invalidToken = new InvalidTokenModel();
            invalidToken.setToken(jwt);
            invalidToken.setExpirationTime(LocalDateTime.now().plusDays(1));
            invalidTokenRepository.save(invalidToken);
        }
        return ResponseEntity.ok(Map.of("message", "Logout successful"));
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<AuthResponseModel> validateToken(@PathVariable(value = "token") String token, Locale locale) {
        String username = jwtUtil.extractUsername(token);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Boolean tokenIsOk = jwtUtil.validateToken(token, userDetails, locale);

        UserModel user = userService.getUserByUsername(username).orElseThrow(() ->
                ResourceUsernameNotFoundException.withMessage(
                        messageSource, ERROR_USER_USERNAME_NOTFOUND,
                        new Object[]{username},
                        locale
                )
        );

        List<RoleModel> roles = user.getAuthorities() != null
                ? user.getAuthorities().stream()
                .map(RoleModel.class::cast)
                .toList()
                : List.of();

        return ResponseEntity.ok(
                new AuthResponseModel(token, tokenIsOk, roles.get(0).getRoleName())
        );
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody @Valid AuthChangePasswordRecordDto authChangePasswordRecordDto, Locale locale) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserModel user = userService.getUserByUsername(username).orElseThrow(() ->
            ResourceUsernameNotFoundException.withMessage(
                    messageSource,ERROR_USER_USERNAME_NOTFOUND,
                    new Object[]{username},
                    locale
            )
        );

        if (!passwordEncoder.matches(authChangePasswordRecordDto.oldPassword(), user.getPassword())) {
            throw ResourceBadCredentialsException.withMessage(
                    messageSource,"error.credentials.bad.old.pass",
                    new Object[]{},
                    locale
            );
        }
        user.setPassword(authChangePasswordRecordDto.newPassword());
        userService.saveUser(user);

        return ResponseEntity.ok("Password changed successfully!");
    }

    private AuthResponseDto mapToAuthResponseDto(String jwt, Boolean isOk, UserModel userModel){
        List<RoleModel> roles = (userModel.getAuthorities() == null)
                ? List.of()
                : userModel.getAuthorities().stream()
                .map(RoleModel.class::cast)
                .toList();

        UserRoleResponseDto userDto = new UserRoleResponseDto(
                userModel.getIdUser(),
                userModel.getName(),
                userModel.getEmail(),
                userModel.getUsername(),
                userModel.getAccountNonExpired(),
                userModel.getAccountNonLocked(),
                userModel.getCredentialsNonExpired(),
                userModel.getEnabled(),
                roles);

            return new AuthResponseDto(jwt, isOk, userDto);
        }
    }

