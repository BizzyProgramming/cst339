package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gcu")
public class Topic63Application {

	public static void main(String[] args) {
		SpringApplication.run(Topic63Application.class, args);
		
		String plainTextPassword = "Thekillers7!";
		SecurityConfig sc = new SecurityConfig();
		sc.encryptPasswordDiplay(plainTextPassword);
//		SecurityConfig.encryptPasswordDiplay("ya password");
	}

}
