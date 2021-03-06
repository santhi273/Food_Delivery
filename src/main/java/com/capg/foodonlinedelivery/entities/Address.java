package com.capg.foodonlinedelivery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * 
 * @author: santhi
 * Description:address Entity
 * date: 3/6/2021
 *
 */
@Entity
public class Address {
	@Id
	@GeneratedValue(generator="address_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="address_seq",sequenceName="address_seq",allocationSize=1)
private Integer addressId;
private String city;
private Integer dNo;
private int pinCode;
private String area;
private String state;
private String country;

public Address() {
	super();
}
public Address(Integer addressId, String city, Integer dNo,int pinCode, String area, String state, String country) {
	super();
	this.addressId = addressId;
	this.city = city;
	this.dNo = dNo;
	this.pinCode = pinCode;
	this.area = area;
	this.state = state;
	this.country = country;
}
public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
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
public int getPinCode() {
	return pinCode;
}
public void setPinCode(int pinCode) {
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
