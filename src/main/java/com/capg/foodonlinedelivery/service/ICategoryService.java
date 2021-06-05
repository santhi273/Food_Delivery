package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.model.CategoryDTO;

public interface ICategoryService {
	public CategoryDTO addCategory(Category category);
    public CategoryDTO updateCategory(Category category);
    public void removeCategory(Category category);
    public CategoryDTO viewCategoryById(String categoryId);
    public List<CategoryDTO> viewAllCategory();
}
