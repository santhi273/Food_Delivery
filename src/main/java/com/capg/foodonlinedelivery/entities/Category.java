package com.capg.foodonlinedelivery.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
private String categoryId;
private String categoryName;


public Category(String categoryId, String categoryName) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}
public Category() {
	super();
}
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

}
