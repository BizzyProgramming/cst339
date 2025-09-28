package com.gcu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.LoginModel;
import com.gcu.model.RegistrationModel;

@Repository
public class UserDAOImpl implements UserDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean createUser(RegistrationModel user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        int result = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return result > 0;
    }

    @Override
    public boolean userExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count != null && count > 0;
    }

    @Override
    public boolean validateUser(LoginModel login) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, login.getUsername(), login.getPassword());
        return count != null && count > 0;
    }
}

