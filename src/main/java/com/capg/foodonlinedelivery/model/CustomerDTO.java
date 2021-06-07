package com.capg.foodonlinedelivery.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;
import com.capg.foodonlinedelivery.entities.Address;

@Component
public class CustomerDTO {
	
	@GeneratedValue(generator="customer_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
	private Integer customerId;
	@NotEmpty(message = "First Name should not be empty")
	@Size(min = 4, max = 15)
	private String firstName;
	@Size(min = 2, max = 15)
	private String lastName;
	@Email(message = "Enter a Valid Email")
	private String emailId;
	private Address address;
	private String gender;
	@Size(min = 10, max = 10)
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
