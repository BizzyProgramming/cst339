package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.model.RegistrationModel;
import com.gcu.dao.UserDAO;
import com.gcu.business.SecurityBusinessService;

import jakarta.validation.Valid;

/**
 * RegistrationController
 *
 * Handles user registration functionality.
 * Displays the registration form, validates input, and creates new user accounts.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SecurityBusinessService securityBusinessService;

    /**
     * Displays the user registration page.
     *
     * @param model the model used to send attributes to the Thymeleaf view
     * @return the registration template name ("registration.html")
     */
    @GetMapping("/register")
    public String displayRegistration(Model model) {
        model.addAttribute("title", "Create Account");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "registration";
    }

    /**
     * Handles form submission for user registration.
     * Performs validation and attempts to create a new user in the database.
     *
     * @param registrationModel the form-bound registration model containing user input
     * @param bindingResult     validation results for the form
     * @param model             the model used to send attributes to the view
     * @return redirect to login page if successful, otherwise redisplays registration page
     */
    @PostMapping("/register/doRegister")
    public String doRegister(
            @Valid RegistrationModel registrationModel,
            BindingResult bindingResult,
            Model model) {

        // Handle validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Account");
            return "registration";
        }

        // Attempt to create the user
        boolean success = userDAO.createUser(registrationModel);
        if (!success) {
            model.addAttribute("registrationError", "Registration failed, try again.");
            return "registration";
        }

        // Redirect to login page after successful registration
        return "redirect:/login/";
    }
}