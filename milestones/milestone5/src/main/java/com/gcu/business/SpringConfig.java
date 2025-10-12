package com.gcu.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public SecurityBusinessService getSecurityBusinessService() {
        return new SecurityBusinessService();
    }
	
}
