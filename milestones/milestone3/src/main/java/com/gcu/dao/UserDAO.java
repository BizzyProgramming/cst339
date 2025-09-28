package com.gcu.dao;

import com.gcu.model.LoginModel;
import com.gcu.model.RegistrationModel;

public interface UserDAO {
    boolean createUser(RegistrationModel user);
    boolean userExists(String username);
    boolean validateuser(LoginModel login);
}
