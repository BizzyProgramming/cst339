package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

@Service
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	@Autowired 
	private OrdersDataService service;

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
		
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity) {
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
	}
}



