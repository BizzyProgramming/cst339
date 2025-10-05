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
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@GetMapping("/testFindAll")
	public String testFindAll(Model model) {
	    List<OrderModel> orders = ordersBusinessService.getOrders();
	    model.addAttribute("title", "Test Find All Orders");
	    model.addAttribute("orders", orders);
	    return "orders"; // Use a separate template to display test results
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
	//	System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
		
		// ordersBusinessService.test();
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		securityBusinessService.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		List<OrderModel> orders = ordersBusinessService.getOrders();
		
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);
		
		return "orders";
		
	}
	
	

}
