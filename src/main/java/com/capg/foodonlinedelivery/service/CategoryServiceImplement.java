package com.capg.foodonlinedelivery.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.model.CategoryDTO;
import com.capg.foodonlinedelivery.repository.ICategoryRepository;
import com.capg.foodonlinedelivery.utils.CategoryUtils;
@Service
public class CategoryServiceImplement implements ICategoryService {
	@Autowired
	ICategoryRepository repo;
	@Override
	public CategoryDTO addCategory(Category category) {

		Category category1= repo.save(category);
		return CategoryUtils.convertToCategoryDto(category1);
	
	}
	
	@Override
	public CategoryDTO updateCategory(Category category) {

		Category category1= repo.save(category);
		return CategoryUtils.convertToCategoryDto(category1);
		
	}

	@Override
	public void removeCategory(Category category) {

		 repo.delete(category);
	}

	@Override
	
	public CategoryDTO viewCategoryById(String categoryId) {

		Category category= repo.findById(categoryId).orElse(new Category());
		return CategoryUtils.convertToCategoryDto(category);
	
	}

	@Override
	public List<CategoryDTO> viewAllCategory() {
		List<Category> list =repo.findAll();
	return CategoryUtils.convertToCategoryDtoList(list);
	
	}

}
