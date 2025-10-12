package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests(authorize -> authorize.requestMatchers("/", "/images/**", "/service/**")
		.permitAll().anyRequest().authenticated()).formLogin().loginPage("/login")
		.usernameParameter("username").passwordParameter("password").permitAll()
		.defaultSuccessUrl("/orders/display", true).and().logout().logoutUrl("/logout")
		.invalidateHttpSession(true).clearAuthentication(true).permitAll().logoutSuccessUrl("/");
		return http.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("test").password("{noop}test").roles("USER");
	}
}
