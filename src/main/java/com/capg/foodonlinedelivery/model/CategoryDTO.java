package com.capg.foodonlinedelivery.model;
import org.springframework.stereotype.Component;
@Component
public class CategoryDTO {
private String categoryId;
private String categoryName;


public CategoryDTO(String categoryId, String categoryName) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}
public CategoryDTO() {
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
