package com.gcu.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfig
 *
 * Configures all Spring Security rules for the web application.
 * Controls which routes are public, which require authentication,
 * and defines the login, logout, and password-handling behavior.
 * 
 * Responsibilities:
 * <ul>
 *   <li>Manage access control for web routes.</li>
 *   <li>Integrate custom authentication logic from {@link SecurityBusinessService}.</li>
 *   <li>Enable both form-based login and REST Basic Authentication.</li>
 *   <li>Configure password hashing and CSRF policy.</li>
 * </ul>
 */
@Configuration
public class WebSecurityConfig {

    /**
     * Configures the main HTTP security rules for the entire web application.
     *
     * @param http the {@link HttpSecurity} builder
     * @param userDetailsService custom {@link SecurityBusinessService} for user authentication
     * @return the configured {@link SecurityFilterChain} bean
     * @throws Exception if configuration fails
     */
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            SecurityBusinessService userDetailsService) throws Exception {

        http
            // 🔐 Access rules
            .authorizeHttpRequests(auth -> auth
                // Public routes accessible to all users
                .requestMatchers("/", "/home", "/login", "/register/**",
                                 "/images/**", "/css/**", "/news").permitAll()

                // Protected routes requiring authentication
                .requestMatchers("/shop", "/orders/**", "/service/**").authenticated()

                // Any other unspecified route requires authentication
                .anyRequest().authenticated()
            )

            // 💻 Custom form-based login configuration
            .formLogin(form -> form
                .loginPage("/login")                 // Custom login page
                .loginProcessingUrl("/doLogin")      // URL for login form submission
                .usernameParameter("username")       // Username field name
                .passwordParameter("password")       // Password field name
                .defaultSuccessUrl("/news", true)    // Redirect after successful login
                .failureUrl("/login?error=true")     // Redirect after failed login
                .permitAll()
            )

            // 🚪 Logout configuration
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )

            // ⚙️ Enable Basic HTTP Authentication (for API testing)
            .httpBasic(withDefaults -> {})

            // ⚠️ Disable CSRF for testing (enable later in production)
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    /**
     * Configures the password encoder bean using BCrypt hashing.
     *
     * @return a {@link BCryptPasswordEncoder} instance for secure password hashing
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Creates and configures the {@link DaoAuthenticationProvider}.
     *
     * @param userDetailsService custom {@link SecurityBusinessService}
     * @param passwordEncoder password encoder bean
     * @return configured {@link DaoAuthenticationProvider} for authentication
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            SecurityBusinessService userDetailsService,
            BCryptPasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    /**
     * Exposes the {@link AuthenticationManager} for use in other components.
     *
     * @param config the {@link AuthenticationConfiguration} provided by Spring
     * @return the {@link AuthenticationManager} bean
     * @throws Exception if retrieval fails
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}