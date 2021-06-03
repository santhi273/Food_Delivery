package com.capg.foodonlinedelivery.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
private String addressId;
private String city;
private Integer dNo;
private Long pinCode;
private String area;
private String state;
private String country;

public Address() {
	super();
}
public Address(String addressId, String city, Integer dNo, Long pinCode, String area, String state, String country) {
	super();
	this.addressId = addressId;
	this.city = city;
	this.dNo = dNo;
	this.pinCode = pinCode;
	this.area = area;
	this.state = state;
	this.country = country;
}
public String getAddressId() {
	return addressId;
}
public void setAddressId(String addressId) {
	this.addressId = addressId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Integer getdNo() {
	return dNo;
}
public void setdNo(Integer dNo) {
	this.dNo = dNo;
}
public Long getPinCode() {
	return pinCode;
}
public void setPinCode(Long pinCode) {
	this.pinCode = pinCode;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

}
