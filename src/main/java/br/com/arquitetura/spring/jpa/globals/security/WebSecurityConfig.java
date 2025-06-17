package br.com.arquitetura.spring.jpa.globals.security;

import br.com.arquitetura.spring.jpa.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final String PAGE = "/page";
    private static final String PARAM_ID = "/{id}";
    private static final String API_PRODUCTS = "/api/products";
    private static final String API_PIECES = "/api/pieces";
    private static final String API_ROLES = "/api/roles";
    private static final String API_USERS = "/api/users";
    private static final String API_DOMAINS = "/api/domains";
    private static final String API_DOMAIN_ITEMS = "/api/domain-items";

    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";

    @Value("${cors.domain.client}")
    String domainClient;

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                // .requestMatchers("/api/**").permitAll()
                                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/swagger-ui.html", "/v3/api-docs.yaml").permitAll()
                                .requestMatchers("/api/login").permitAll()
                                .requestMatchers("/api/logout").permitAll()
                                .requestMatchers("/ws/**").permitAll()
                                .requestMatchers("/api/validate/**").permitAll()
                                .requestMatchers("/api/change-password").authenticated()
                                .requestMatchers(API_PRODUCTS+"/**").authenticated()
                                .requestMatchers(API_PIECES+"/**").authenticated()
                                .requestMatchers(API_ROLES+"/**").authenticated()
                                .requestMatchers(API_USERS+"/**").authenticated()
                                .requestMatchers("/api/activate").permitAll()
                                .requestMatchers(API_DOMAINS+"/**").authenticated()
                                .requestMatchers(API_DOMAIN_ITEMS+"/**").authenticated()
                                .requestMatchers("/api/proxy/**").permitAll()
                                .requestMatchers("/api/files/**").authenticated()

                                //.requestMatchers(HttpMethod.GET, "/ws/topic/messages").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.GET, "/api/proxy/municipios").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.POST, "/api/change-password").hasAnyRole(ROLE_ADMIN, ROLE_USER)

                                .requestMatchers(HttpMethod.GET, API_PRODUCTS+PAGE).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.GET, API_PRODUCTS).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.POST, API_PRODUCTS).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.PUT, API_PRODUCTS+PARAM_ID).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.DELETE, API_PRODUCTS+PARAM_ID).hasRole(ROLE_ADMIN)

                                .requestMatchers(HttpMethod.GET, API_PIECES+PAGE).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.GET, API_PIECES).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.POST, API_PIECES).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.PUT, API_PIECES+PARAM_ID).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.DELETE, API_PIECES+PARAM_ID).hasRole(ROLE_ADMIN)

                                .requestMatchers(HttpMethod.GET, API_ROLES+PAGE).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.GET, API_ROLES).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.POST, API_ROLES).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.PUT, API_ROLES+PARAM_ID).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.DELETE, API_ROLES+PARAM_ID).hasRole(ROLE_ADMIN)

                                .requestMatchers(HttpMethod.GET, API_USERS+PAGE).hasRole(ROLE_ADMIN)
                                .requestMatchers(HttpMethod.GET, API_USERS).hasRole(ROLE_ADMIN)
                                .requestMatchers(HttpMethod.POST, API_USERS).hasRole(ROLE_ADMIN)
                                .requestMatchers(HttpMethod.PUT, API_USERS+PARAM_ID).hasRole(ROLE_ADMIN)
                                .requestMatchers(HttpMethod.DELETE, API_USERS+PARAM_ID).hasRole(ROLE_ADMIN)

                                .requestMatchers(HttpMethod.GET, "/api/domains/page").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                //.requestMatchers(HttpMethod.GET, API_DOMAINS+PAGE).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.GET, API_DOMAINS).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.POST, API_DOMAINS).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.PUT, API_DOMAINS+PARAM_ID).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.DELETE, API_DOMAINS+PARAM_ID).hasAnyRole(ROLE_ADMIN, ROLE_USER)

                                .requestMatchers(HttpMethod.GET, API_DOMAIN_ITEMS+PAGE).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.GET, API_DOMAIN_ITEMS).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.POST, API_DOMAIN_ITEMS).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.PUT, API_DOMAIN_ITEMS+PARAM_ID).hasAnyRole(ROLE_ADMIN, ROLE_USER)
                                .requestMatchers(HttpMethod.DELETE, API_DOMAIN_ITEMS+PARAM_ID).hasAnyRole(ROLE_ADMIN, ROLE_USER)

                                .requestMatchers(HttpMethod.GET, "/api/files/{filename:.+}").hasAnyRole(ROLE_ADMIN, ROLE_USER)

                                .requestMatchers(HttpMethod.GET, "/api/pokemon").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/generation").permitAll()

                                .anyRequest().authenticated()
                )
                .cors(withDefaults())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    // Configuração de CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(domainClient)); // Permite todas as origens (ajuste conforme necessário)
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
