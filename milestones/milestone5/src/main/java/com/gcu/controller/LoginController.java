package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private OrdersBusinessInterface ordersBusinessService;

    @Autowired
    private SecurityBusinessService securityBusinessService;

    // Display the login page
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    // Handle login form submission
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login");
            return "login";
        }

        // Use the LoginModel object instead of raw strings
        boolean isAuthenticated = securityBusinessService.authenticate(loginModel);

        if (!isAuthenticated) {
            model.addAttribute("loginError", "Invalid username or password.");
            return "login";
        }

        // Get orders for authenticated user
        List<OrderModel> orders = ordersBusinessService.getOrders();
        model.addAttribute("title", "Shop Items");
        model.addAttribute("orders", orders);

        return "orders";
    }
}
