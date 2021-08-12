package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.model.CategoryDTO;

public interface ICategoryService {
	public CategoryDTO addCategory(Category category);
    public CategoryDTO updateCategory(Category category);
    public void removeCategory(Integer categoryId);
    public CategoryDTO viewCategoryById(Integer categoryId);
    public List<CategoryDTO> viewAllCategory();
}
