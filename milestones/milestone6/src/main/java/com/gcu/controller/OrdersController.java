package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.OrderModel;

@Controller
public class OrdersController {

    @Autowired
    private OrdersBusinessInterface ordersBusinessService;

    @GetMapping("/orders")
    public String displayOrders(Model model) {
        List<OrderModel> orders = ordersBusinessService.getOrders();
        model.addAttribute("title", "Shop Items");
        model.addAttribute("orders", orders);
        return "orders"; // orders.html
    }
}
