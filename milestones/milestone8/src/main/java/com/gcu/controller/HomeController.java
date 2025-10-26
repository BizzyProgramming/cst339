package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 *
 * Handles navigation for the home page and news/events page.
 * Provides basic entry points for visitors and authenticated users.
 */
@Controller
public class HomeController {

    /**
     * Displays the home page of the application.
     *
     * @param model the model used to send attributes to the Thymeleaf view
     * @return the name of the home page template ("home.html")
     */
    @GetMapping({"/", "/home"})
    public String displayHome(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }

    /**
     * Displays the news and events page.
     *
     * @param model the model used to send attributes to the Thymeleaf view
     * @return the name of the news/events template ("news.html")
     */
    @GetMapping("/news")
    public String displayNews(Model model) {
        model.addAttribute("title", "News and Events");
        return "news";
    }
}