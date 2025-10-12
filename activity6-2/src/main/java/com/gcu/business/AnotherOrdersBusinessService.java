package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessInterface{
	@Override
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService");
	}
	
	@Override
	public void init() {
		System.out.println("Init method called in AnotherOrdersBusinesService");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method called in AnotherOrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders() {
		return null;
	}
	
	@Override
	public OrderModel getOrderById(String id) {
		return null;
	}
	
}
