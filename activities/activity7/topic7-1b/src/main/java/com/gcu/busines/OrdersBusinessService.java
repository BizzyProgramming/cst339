package com.gcu.busines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;

@Service
public class OrdersBusinessService {

	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public OrdersBusinessService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}
	
	public List<OrderModel> getAllOrders() {
		List<OrderEntity> ordersEntity = ordersRepository.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity) {
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
	}
}
