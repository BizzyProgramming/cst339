package com.gcu.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * This class defines all the Spring Security rules for your web application.
 * It handles:
 *   - Which URLs require authentication
 *   - Which pages are publicly accessible
 *   - How login, logout, and REST API access are handled
 *   - Enabling both Form Login (for website) and Basic Auth (for REST APIs)
 */
@Configuration
public class WebSecurityConfig {

    /**
     * Main security configuration method.
     * Defines how HTTP requests are secured throughout the app.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityBusinessService userDetailsService) throws Exception {

        http
            // Define which routes are open and which require login
            .authorizeHttpRequests(auth -> auth
                // Public routes — no login required
                .requestMatchers("/", "/home", "/login", "/register/**", "/images/**", "/css/**").permitAll()

                // Protected routes — require authentication
                .requestMatchers("/orders/**", "/service/**").authenticated() // Added /service/** for Milestone 7

                // Any other request should also require authentication
                .anyRequest().authenticated()
            )

            // 💡 Enable form-based login for the web app (login.html)
            .formLogin(form -> form
                .loginPage("/login")                  // Custom login page
                .loginProcessingUrl("/login")         // Form action URL for Spring Security
                .usernameParameter("username")        // Matches your login form input name
                .passwordParameter("password")        // Matches your password input name
                .defaultSuccessUrl("/orders", true)   // Redirect after successful login
                .permitAll()
            )

            // 🚪 Enable logout functionality for web users
            .logout(logout -> logout
                .logoutUrl("/logout")                 // Logout endpoint
                .logoutSuccessUrl("/home")            // Redirect here after logout
                .permitAll()
            )

            // ⚙️ Enable Basic HTTP Authentication for REST APIs
            // This allows Postman or browsers to use Basic Auth on endpoints like /service/products
            .httpBasic(withDefaults -> { })

            // ⚠️ Disable CSRF for simplicity in Postman testing (good for dev phase)
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    /**
     * Password encoder bean using BCrypt hashing.
     * Ensures user passwords are stored securely in the database.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Authentication provider that connects Spring Security
     * to your custom SecurityBusinessService for user authentication.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            SecurityBusinessService userDetailsService,
            BCryptPasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); // Load users from DB
        provider.setPasswordEncoder(passwordEncoder);       // Compare hashed passwords
        return provider;
    }

    /**
     * Exposes the AuthenticationManager so it can be used elsewhere
     * (e.g., in custom login services or testing).
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}