package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.gcu.dao.UserDAO;
import com.gcu.model.RegistrationModel;
import java.util.Collections;

/**
 * SecurityBusinessService
 * 
 * Implements Spring Security’s {@link UserDetailsService} to handle authentication logic.
 * Retrieves user information from the {@link UserDAO} and provides user credentials
 * to the Spring Security framework.
 * 
 * Responsibilities:
 * <ul>
 *   <li>Load user details (username and password) during login.</li>
 *   <li>Provide password hashing via BCrypt for secure storage.</li>
 *   <li>Integrate authentication logic between the data access and security layers.</li>
 * </ul>
 */
@Service
public class SecurityBusinessService implements UserDetailsService {

    /**
     * DAO used to query user account data from the database.
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Password encoder for hashing and verifying passwords.
     */
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Loads user details by username for authentication.
     *
     * @param username the username provided at login
     * @return a {@link UserDetails} object containing the user’s credentials and authorities
     * @throws UsernameNotFoundException if no matching user is found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegistrationModel user = userDAO.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Return a Spring Security User object for authentication
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(Collections.emptyList()) // No roles configured
                .build();
    }

    /**
     * Hashes a plain-text password using BCrypt.
     *
     * @param plainPassword the plain-text password entered by the user
     * @return a hashed password suitable for storage in the database
     */
    public String hashPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }
}