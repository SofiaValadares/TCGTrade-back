package br.com.arquitetura.spring.jpa.globals.security;

import br.com.arquitetura.spring.jpa.globals.security.JwtUtil;
import br.com.arquitetura.spring.jpa.repositories.InvalidTokenRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JwtUtilTest {

    @InjectMocks
    private JwtUtil jwtUtil;

    private final String secret = "mySecretKeyThatIsVerySecretAndNeedsToBe32CharsLong";
    long expirationInHours = 5L;

    private SecretKey secretKey;
//    @BeforeEach
//    void setUp() {
//        jwtUtil = new JwtUtil();
//        jwtUtil.secret = secret;  // Set the secret key for the tests
//        jwtUtil.expirationInHours = expirationInHours;  // Set expiration
//        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
//    }

//    @Test
//    void testExtractUsername() {
//        // Given
//        String token = "valid.token.structure";
//        Claims claims = mock(Claims.class);
//        when(claims.getSubject()).thenReturn("testUser");
//
//        Jws<Claims> jwsClaims = mock(Jws.class);
//        when(jwsClaims.getBody()).thenReturn(claims);
//
//        // Mock the JwtParser and JwtParserBuilder chain
//        JwtParser jwtParser = mock(JwtParser.class);
//        when(jwtParser.parseClaimsJws(token)).thenReturn(jwsClaims);
//
//        JwtParserBuilder jwtParserBuilder = mock(JwtParserBuilder.class);
//        when(jwtParserBuilder.setSigningKey(secretKey)).thenReturn(jwtParserBuilder);
//        when(jwtParserBuilder.build()).thenReturn(jwtParser);
//
//        // Mock the static call to Jwts.parserBuilder() to return the mocked JwtParserBuilder
//        try (MockedStatic<Jwts> jwtsMockedStatic = mockStatic(Jwts.class)) {
//            jwtsMockedStatic.when(Jwts::parserBuilder).thenReturn(jwtParserBuilder);
//
//            // When
//            String username = jwtUtil.extractUsername(token);
//
//            // Then
//            assertEquals("testUser", username);
//        }
//    }
//
//    @Test
//    void testExtractExpiration() {
//        // Given
//        String token = "testToken";
//        Claims claims = mock(Claims.class);
//        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);  // 1 hour in future
//        when(claims.getExpiration()).thenReturn(expirationDate);
//
//        // Mock the JWT parser to return our mocked claims
//        try (MockedStatic<Jwts> jwtsMockedStatic = mockStatic(Jwts.class)) {
//            jwtsMockedStatic.when(() -> Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()).thenReturn(claims);
//
//            // When
//            Date extractedDate = jwtUtil.extractExpiration(token);
//
//            // Then
//            assertEquals(expirationDate, extractedDate);
//        }
//    }

//    @Test
//    void testGenerateToken() throws Exception {
//        // Given
//        InvalidTokenRepository mockRepo = mock(InvalidTokenRepository.class);
//        MessageSource mockMessageSource = mock(MessageSource.class);
//        JwtUtil jwtUtil = new JwtUtil(mockRepo, mockMessageSource);
//
//        // Setar a secret key por reflexão
//        String rawSecret = "my-secret-key-test";
//        String base64Secret = Base64.getEncoder().encodeToString(rawSecret.getBytes());
//
//        Field secretKeyField = JwtUtil.class.getDeclaredField("secretKey");
//        secretKeyField.setAccessible(true);
//        secretKeyField.set(jwtUtil, base64Secret);
//
//        UserDetails userDetails = mock(UserDetails.class);
//        when(userDetails.getUsername()).thenReturn("testUser");
//
//        // When
//        String token = jwtUtil.generateToken(userDetails);
//
//        // Then
//        assertNotNull(token);
//        assertFalse(token.isBlank());
//    }

//    @Test
//    void testIsTokenExpired_False() {
//        // Given
//        String token = "testToken";
//        Claims claims = mock(Claims.class);
//        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);  // 1 hour in future
//        when(claims.getExpiration()).thenReturn(futureDate);
//
//        // Mock the JWT parser to return our mocked claims
//        try (MockedStatic<Jwts> jwtsMockedStatic = mockStatic(Jwts.class)) {
//            jwtsMockedStatic.when(() -> Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()).thenReturn(claims);
//
//            // When
//            Boolean isExpired = jwtUtil.validateToken(token, mock(UserDetails.class));
//
//            // Then
//            assertFalse(isExpired);
//        }
//    }
//
//    @Test
//    void testValidateToken_ValidToken() {
//        // Given
//        String token = "testToken";
//        UserDetails userDetails = mock(UserDetails.class);
//        when(userDetails.getUsername()).thenReturn("testUser");
//
//        Claims claims = mock(Claims.class);
//        when(claims.getSubject()).thenReturn("testUser");
//        when(claims.getExpiration()).thenReturn(new Date(System.currentTimeMillis() + 1000 * 60 * 60));  // 1 hour in future
//
//        // Mock the JWT parser to return our mocked claims
//        try (MockedStatic<Jwts> jwtsMockedStatic = mockStatic(Jwts.class)) {
//            jwtsMockedStatic.when(() -> Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()).thenReturn(claims);
//
//            // When
//            Boolean isValid = jwtUtil.validateToken(token, userDetails);
//
//            // Then
//            assertTrue(isValid);
//        }
//    }
}
