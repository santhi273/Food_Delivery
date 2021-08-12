package com.capg.foodonlinedelivery.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class CustomerLoginDTO {
	
	private int userId;
	@NotEmpty(message = "User Name should not be empty")
	private String userName;
	@Size(min=5, max=15, message="Password length should be between 5 and 15")
	private String password;
	
	
	public CustomerLoginDTO() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "CustomerLoginDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	

}
