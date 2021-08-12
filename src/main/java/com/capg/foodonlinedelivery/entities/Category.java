package com.capg.foodonlinedelivery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
/**
 * 
 * @author: santhi
 * Description:address Entity
 * date: 3/6/2021
 *
 */
@Entity
public class Category {
	@Id
	@GeneratedValue(generator = "category_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
	private Integer categoryId;
	private String categoryName;

	public Category(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;

		this.categoryName = categoryName;
	}

	public Category() {
		super();
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
