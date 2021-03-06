package com.capg.foodonlinedelivery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
/**
 * 
 * @author: mithila
 * Description:customer login Entity
 * date: 3/6/2021
 *
 */
@Entity
public class CustomerLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Column(unique=true)
	private String userName;
	private String password;
	public CustomerLogin() {
		super();
	}
	
	public CustomerLogin(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
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
		return "CustomerLogin [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	

}
