package com.capg.foodonlinedelivery.model;

import org.springframework.stereotype.Component;

import com.capg.foodonlinedelivery.entities.Address;

@Component
public class CustomerDTO {

	private Integer customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Address address;
	private String gender;
	private Long phoneNumber;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(Integer customerId, String firstName, String lastName, String emailId, Address address,
			String gender, Long phoneNumber) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
