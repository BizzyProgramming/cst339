package com.gcu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.gcu.model.RegistrationModel;
import com.gcu.model.LoginModel;

/**
 * UserDAOImpl
 *
 * Implements {@link UserDAO} using JDBC for database access.
 * Provides functionality for user registration, authentication,
 * and lookup operations.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private DataSource dataSource;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Inserts a new user record into the database.
     * Passwords are hashed using BCrypt before being stored.
     *
     * @param registration the {@link RegistrationModel} containing new user data
     * @return true if the operation succeeds; false otherwise
     */
    @Override
    public boolean createUser(RegistrationModel registration) {
        String sql = "INSERT INTO users (username, password, email, created_at) VALUES (?, ?, ?, NOW())";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String hashedPassword = passwordEncoder.encode(registration.getPassword());

            stmt.setString(1, registration.getUsername());
            stmt.setString(2, hashedPassword);
            stmt.setString(3, registration.getEmail());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Checks if a given username already exists in the database.
     *
     * @param username the username to check
     * @return true if the user exists; false otherwise
     */
    @Override
    public boolean userExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Validates the given login credentials by comparing the stored hash.
     *
     * @param login the {@link LoginModel} containing username and password
     * @return true if credentials are valid; false otherwise
     */
    @Override
    public boolean validateuser(LoginModel login) {
        String sql = "SELECT password FROM users WHERE username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getUsername());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString("password");
                return passwordEncoder.matches(login.getPassword(), storedHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retrieves user details by username for Spring Security authentication.
     *
     * @param username the username to look up
     * @return a {@link RegistrationModel} with user info, or null if not found
     */
    @Override
    public RegistrationModel findByUsername(String username) {
        String sql = "SELECT username, password, email FROM users WHERE username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                RegistrationModel user = new RegistrationModel();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}