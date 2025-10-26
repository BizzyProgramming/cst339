package com.gcu.dao;

import com.gcu.model.LoginModel;
import com.gcu.model.RegistrationModel;

/**
 * UserDAO
 *
 * Defines the contract for all database operations related to user accounts,
 * including registration, login validation, and account lookup.
 */
public interface UserDAO {

    /**
     * Creates a new user record in the database.
     *
     * @param user the {@link RegistrationModel} containing registration details
     * @return true if user creation succeeds; false otherwise
     */
    boolean createUser(RegistrationModel user);

    /**
     * Checks if a username already exists.
     *
     * @param username the username to check
     * @return true if the username exists; false otherwise
     */
    boolean userExists(String username);

    /**
     * Validates login credentials.
     *
     * @param login the {@link LoginModel} containing username and password
     * @return true if credentials match; false otherwise
     */
    boolean validateuser(LoginModel login);

    /**
     * Retrieves user details by username (used by Spring Security).
     *
     * @param username the username to search
     * @return a {@link RegistrationModel} representing the user, or null if not found
     */
    RegistrationModel findByUsername(String username);
}