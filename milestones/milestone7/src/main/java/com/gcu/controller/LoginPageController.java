package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("title", "Login");
        return "login"; // this returns login.html Thymeleaf page
    }
    
}
