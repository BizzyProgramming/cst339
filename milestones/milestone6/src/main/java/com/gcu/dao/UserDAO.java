package com.gcu.dao;

import com.gcu.model.LoginModel;
import com.gcu.model.RegistrationModel;

// DAO interface for user operations (login and registration)
public interface UserDAO {

    boolean createUser(RegistrationModel user);
    boolean userExists(String username);
    boolean validateuser(LoginModel login);

    // NEW: Fetch user info by username for Spring Security
    RegistrationModel findByUsername(String username);
}