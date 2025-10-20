package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.OrderModel;

@Controller
public class OrdersController {

    @Autowired
    private ProductBusinessInterface productBusinessService;

    @GetMapping("/orders")
    public String displayOrders(Model model) {
        List<OrderModel> orders = productBusinessService.getAllProducts();
        model.addAttribute("title", "Shop Items");
        model.addAttribute("orders", orders);
        return "orders"; // orders.html
    }
}
