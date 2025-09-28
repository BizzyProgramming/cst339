package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {
	public boolean authenticate(String username, String password) {
		System.out.println("Hello from the SecurityBusinessService");
		System.out.println("Also this is the Part 2: Creating Data Services using Spring Data JDBC");
		return true;
	}
}
