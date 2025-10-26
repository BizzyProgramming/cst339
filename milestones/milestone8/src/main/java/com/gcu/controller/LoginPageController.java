package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * LoginPageController
 *
 * Manages the login and already-logged-in pages.
 * The login form submission is handled automatically by Spring Security.
 */
@Controller
public class LoginPageController {

    /**
     * Displays the login page.
     * The POST request is processed by Spring Security (/doLogin).
     *
     * @param model the model used to send attributes to the Thymeleaf view
     * @return the name of the login page template ("login.html")
     */
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    /**
     * Displays a page notifying the user that they are already logged in.
     *
     * @param model the model used to send attributes to the Thymeleaf view
     * @return the name of the already-logged-in template ("alreadyLoggedIn.html")
     */
    @GetMapping("/alreadyLoggedIn")
    public String showAlreadyLoggedInPage(Model model) {
        model.addAttribute("title", "Already Logged In");
        model.addAttribute("message", "You are already logged in.");
        return "alreadyLoggedIn";
    }
}
