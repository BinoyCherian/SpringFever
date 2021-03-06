package com.binoy.pojo;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Login {
	
	@NotEmpty(message="Please enter your username")
	String username;
	
	@NotEmpty(message="Please enter your password")
	
	String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
