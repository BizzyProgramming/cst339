package com.gcu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gcu.model.RegistrationModel;
import com.gcu.model.LoginModel;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public boolean createUser(RegistrationModel registration) {
        String sql = "INSERT INTO users (username, password, email, created_at) VALUES (?, ?, ?, NOW())";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, registration.getUsername());
            stmt.setString(2, registration.getPassword());
            stmt.setString(3, registration.getEmail());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean userExists(String username) {
        // TODO: implement a SELECT query if you want
        return false;
    }

   @Override
    public boolean validateuser(LoginModel login) {
    String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, login.getUsername());
        stmt.setString(2, login.getPassword());

        var rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // true if a user exists
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}