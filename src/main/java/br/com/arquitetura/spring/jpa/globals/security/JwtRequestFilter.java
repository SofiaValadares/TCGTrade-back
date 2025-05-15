package br.com.arquitetura.spring.jpa.globals.security;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.GlobalExceptionHandler;
import br.com.arquitetura.spring.jpa.services.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Locale;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;

    public JwtRequestFilter(UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        Locale locale = request.getLocale();

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtUtil.extractUsername(jwtToken);
            } catch (IllegalArgumentException e) {
                GlobalExceptionHandler.handleAuthException(response, "Nao e possível obter o token JWT.");
                return;
            } catch (ExpiredJwtException e) {
                GlobalExceptionHandler.handleAuthException(response, "Token JWT expirou.");
                return;
            } catch (SignatureException e) {
                GlobalExceptionHandler.handleAuthException(response, "Assinatura de token JWT invalida.");
                return;
            } catch (JwtException e) {
                GlobalExceptionHandler.handleAuthException(response, "Erro ao validar o token JWT.");
                return;
            }
        } else {
            logger.warn("O token JWT não começa com o String Bearer.");
        }

        // Depois de obter o token, valide-o.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // se o token for válido, configure o Spring Security para definir manualmente a autenticação
            if (Boolean.TRUE.equals(jwtUtil.validateToken(jwtToken, userDetails, locale))) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Após definir a Autenticação no contexto, especificamos
                // que o usuário atual está autenticado. Assim, passa com sucesso pelas Configurações do Spring Security.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }
}
