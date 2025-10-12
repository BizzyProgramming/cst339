package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessInterface {

	@Autowired
	private DataAccessInterface<OrderModel> service;
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}
	
	@Override
	public void init() {
		System.out.println("Init method called in OrderBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method called in OrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders() {
	return service.findAll();	
	}
}


