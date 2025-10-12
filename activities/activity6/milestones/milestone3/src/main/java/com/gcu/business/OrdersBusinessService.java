package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessInterface {

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
		
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "1", "Magic Plate Armor", 4.99f, 25));
		orders.add(new OrderModel(1L, "2", "Demon Legs", 4.99f, 25));
		orders.add(new OrderModel(2L, "3", "Demon Helmet", 4.99f, 75));
		orders.add(new OrderModel(3L, "4", "Magic Shield", 4.99f, 100));
		orders.add(new OrderModel(4L, "5", "Bizzy's Wand of Light", 19.99f, 250));
		return orders;
	}
}



