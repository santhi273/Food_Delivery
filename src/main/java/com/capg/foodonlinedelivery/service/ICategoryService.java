package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Category;

public interface ICategoryService {
public Category addCategory(Category category);
public Category updateCategory(Category category);
public void removeCategory(Category category);
public Category viewCategoryById(String categoryId);
public List<Category> viewAllCategory();
}
