package com.gcu.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean(name="ordersBusinessService")
	public OrdersBusinessInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
}
