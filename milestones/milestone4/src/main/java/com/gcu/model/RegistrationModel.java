package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationModel {

    @NotNull(message="Username is required")
    @Size(min=1, max=32, message="Username must be between 1 and 32 characters")
    private String username;

    @NotNull(message="Password is required")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;

    @NotNull(message="Email is required")
    @Size(min=1, max=64, message="Email must be between 1 and 64 characters")
    private String email;

    // Getters & setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}