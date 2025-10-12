package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.model.RegistrationModel;
import com.gcu.dao.UserDAO;
import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/register")
    public String displayRegistration(Model model) {
        model.addAttribute("title", "Create Account");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "registration";
    }

    @PostMapping("/register/doRegister")
    public String doRegister(@Valid RegistrationModel registrationModel, 
                             BindingResult bindingResult, 
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Account");
            return "registration";
        }

        boolean success = userDAO.createUser(registrationModel);
        if (!success) {
            model.addAttribute("registrationError", "Registration failed, try again.");
            return "registration";
        }

        return "redirect:/login/";
    }
}