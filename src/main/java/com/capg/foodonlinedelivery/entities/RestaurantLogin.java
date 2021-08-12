package com.capg.foodonlinedelivery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 
 * @author: hemalatha
 * Description:restaurant login Entity
 * date: 3/6/2021
 *
 */
@Entity
public class RestaurantLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	@Column(unique=true)
	@NotEmpty(message = "Username should not be empty...")
	private String userName;
	@NotEmpty(message = "Password should not be empty...")
	@Size(min = 5,max = 10,message = "Password length should be between 5 and 10")
	private String password;
	
	public RestaurantLogin() {
		super();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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


}
