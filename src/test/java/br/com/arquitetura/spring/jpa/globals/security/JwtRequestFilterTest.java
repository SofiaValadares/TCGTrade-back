package br.com.arquitetura.spring.jpa.globals.security;

import br.com.arquitetura.spring.jpa.services.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JwtRequestFilterTest {

    @InjectMocks
    private JwtRequestFilter jwtRequestFilter;

    @Mock
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        SecurityContextHolder.clearContext();
    }

    @Test
    void testDoFilterInternal_IllegalArgumentException() throws ServletException, IOException {
        // Given
        String jwtToken = "Bearer expiredToken";
        when(request.getHeader("Authorization")).thenReturn(jwtToken);
        doThrow(new IllegalArgumentException("Illegal Argument")).when(jwtUtil).extractUsername(anyString());

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // When
        jwtRequestFilter.doFilterInternal(request, response, filterChain);

        // Then
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(response, times(1)).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(filterChain, times(0)).doFilter(request, response);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonResponse = objectMapper.readValue(stringWriter.toString(), Map.class);

        printWriter.flush();
        assertTrue(stringWriter.toString().contains("Nao e possível obter o token JWT."));
        assertEquals("Nao e possível obter o token JWT.", jsonResponse.get("message"));
    }


    @Test
    void testDoFilterInternal_ValidToken() throws ServletException, IOException {
        // Given
        String jwtToken = "Bearer validToken";
        String username = "testUser";
        UserDetails userDetails = mock(UserDetails.class);

        when(request.getHeader("Authorization")).thenReturn(jwtToken);
        when(jwtUtil.extractUsername(anyString())).thenReturn(username);
        when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
        //when(jwtUtil.validateToken(anyString(), eq(userDetails)), 'us').thenReturn(true);

        // When
        jwtRequestFilter.doFilterInternal(request, response, filterChain);

        // Then
      //  assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        verify(filterChain, times(1)).doFilter(request, response);
    }

    @Test
    void testDoFilterInternal_ExpiredToken() throws ServletException, IOException {
        // Given
        String jwtToken = "Bearer expiredToken";
        when(request.getHeader("Authorization")).thenReturn(jwtToken);
        doThrow(new ExpiredJwtException(null, null, "Token expired")).when(jwtUtil).extractUsername(anyString());

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // When
        jwtRequestFilter.doFilterInternal(request, response, filterChain);

        // Then
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(response, times(1)).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(filterChain, times(0)).doFilter(request, response);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonResponse = objectMapper.readValue(stringWriter.toString(), Map.class);

        printWriter.flush();
        assertTrue(stringWriter.toString().contains("Token JWT expirou."));
        assertEquals("Token JWT expirou.", jsonResponse.get("message"));
    }

    @Test
    void testDoFilterInternal_InvalidSignatureToken() throws ServletException, IOException {
        // Given
        String jwtToken = "Bearer invalidSignatureToken";
        when(request.getHeader("Authorization")).thenReturn(jwtToken);
        doThrow(new SignatureException("Invalid signature")).when(jwtUtil).extractUsername(anyString());

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // When
        jwtRequestFilter.doFilterInternal(request, response, filterChain);

        // Then
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(response, times(1)).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(filterChain, times(0)).doFilter(request, response);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonResponse = objectMapper.readValue(stringWriter.toString(), Map.class);

        printWriter.flush();
        assertTrue(stringWriter.toString().contains("Assinatura de token JWT invalida."));
        assertEquals("Assinatura de token JWT invalida.", jsonResponse.get("message"));
    }

    @Test
    void testDoFilterInternal_NoToken() throws ServletException, IOException {
        // Given
        when(request.getHeader("Authorization")).thenReturn(null);

        // When
        jwtRequestFilter.doFilterInternal(request, response, filterChain);

        // Then
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(filterChain, times(1)).doFilter(request, response);
    }

    @Test
    void testDoFilterInternal_JwtException() throws ServletException, IOException {
        // Given
        String jwtToken = "Bearer malformedToken";
        when(request.getHeader("Authorization")).thenReturn(jwtToken);
        doThrow(new JwtException("Malformed token")).when(jwtUtil).extractUsername(anyString());

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // When
        jwtRequestFilter.doFilterInternal(request, response, filterChain);

        // Then
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(response, times(1)).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(filterChain, times(0)).doFilter(request, response);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonResponse = objectMapper.readValue(stringWriter.toString(), Map.class);

        printWriter.flush();
        assertTrue(stringWriter.toString().contains("Erro ao validar o token JWT."));
        assertEquals("Erro ao validar o token JWT.", jsonResponse.get("message"));
    }
}
