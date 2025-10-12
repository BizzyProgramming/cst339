package com.gcu.controller;

import com.gcu.model.RegisterModel;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Use RegisterModel instead of Trainer
        model.addAttribute("registerModel", new RegisterModel());
        return "register"; // Thymeleaf template: register.html
    }

    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("registerModel") RegisterModel registerModel,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            // Redisplay form with validation errors
            return "register"; 
        }

        // For Milestone 2, no database — just print to console
        System.out.println("New User Registered:");
        System.out.println("Name: " + registerModel.getFirstName() + " " + registerModel.getLastName());
        System.out.println("Email: " + registerModel.getEmail());
        System.out.println("Username: " + registerModel.getUsername());

        model.addAttribute("message", "Welcome, " + registerModel.getFirstName() + "! Your account has been created.");
        return "registerSuccess.html"; 
    }
}