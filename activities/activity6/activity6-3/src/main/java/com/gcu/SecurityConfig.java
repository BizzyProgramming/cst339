package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserBusinessService;


@Configuration
public class SecurityConfig {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserBusinessService service;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable().httpBasic().and().authorizeRequests(authorize -> authorize.requestMatchers("/", "/home", "/images/**", "/displayOauthCode")
		.permitAll().anyRequest().authenticated()).formLogin().loginPage("/login")
		.usernameParameter("username").passwordParameter("password").permitAll()
		.defaultSuccessUrl("/orders/display", true).and().logout().logoutUrl("/logout")
		.invalidateHttpSession(true).clearAuthentication(true).permitAll().logoutSuccessUrl("/");
		return http.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
	}
	
	public static String encryptPasswordDiplay(String plainTextPassword) {
		String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
		System.out.println("Encrypted Password: " + encoded);
		return encoded;
	}
}
