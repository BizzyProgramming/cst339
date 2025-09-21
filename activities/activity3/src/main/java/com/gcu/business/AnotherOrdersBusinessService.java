package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessInterface{
	@Override
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders() {
		return new ArrayList<>();
	}
	
}
