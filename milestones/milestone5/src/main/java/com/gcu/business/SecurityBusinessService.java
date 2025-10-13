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

@Service
public class SecurityBusinessService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    // Create encoder here — no circular dependency
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegistrationModel user = userDAO.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

    // ✅ Needed by RegistrationController
    public String hashPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }
}
