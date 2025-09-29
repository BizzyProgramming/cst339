package com.gcu.business;

// Spring annotations
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

// DAO and models
import com.gcu.dao.UserDAO;
import com.gcu.model.LoginModel;

@Service // Marks this as a Spring service bean
public class SecurityBusinessService {

    @Autowired
    private UserDAO userDAO;

    public boolean authenticate(LoginModel login) {
        return userDAO.validateuser(login);
    }
}
