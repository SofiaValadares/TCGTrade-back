package br.com.arquitetura.spring.jpa.globals.security;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceUnauthorizedException;
import br.com.arquitetura.spring.jpa.repositories.InvalidTokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.context.MessageSource;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    private final InvalidTokenRepository invalidTokenRepository;
    private final MessageSource messageSource;

    public JwtUtil(
            InvalidTokenRepository invalidTokenRepository,
            MessageSource messageSource) {
        this.invalidTokenRepository = invalidTokenRepository;
        this.messageSource = messageSource;
    }

    @Value("${jwt.secret}")
    String secret;

    @Value("${jwt.token.expiration.hours}")
    long expirationInHours;

    // Extract username from the token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract expiration date from the token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract specific claim from the token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // Check if the token has expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generate token for user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    // Create token with claims
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * expirationInHours))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    // Validate token
    public Boolean validateToken(String token, UserDetails userDetails, Locale locale) {
//        if (invalidTokenRepository.existsByToken(token)) {
//            return false;
//        }

        if (invalidTokenRepository.existsByToken(token)) {
            System.out.println("aqui 1");
            throw ResourceUnauthorizedException.withMessage(
                    messageSource, "error.token.invalid",
                    new Object[]{token},
                    locale
            );
        }
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
