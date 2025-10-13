package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String displayHome(Model model) {
        model.addAttribute("title", "Home");
        return "home"; // home.html
    }

    @GetMapping("/news")
    public String displayNews(Model model) {
        model.addAttribute("title", "News and Events");
        return "news"; // news.html
    }
}