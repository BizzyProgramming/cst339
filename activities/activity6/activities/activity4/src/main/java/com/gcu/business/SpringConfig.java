package com.gcu.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
//import org.springframework.web.context.annotation.SessionScope;
//import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SpringConfig {

	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	@RequestScope
//	@SessionScope
	
	public OrdersBusinessInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
}
