package com.capg.foodonlinedelivery.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.model.CategoryDTO;
import com.capg.foodonlinedelivery.repository.ICategoryRepository;
import com.capg.foodonlinedelivery.utils.CategoryUtils;
@Service
public class CategoryServiceImplement implements ICategoryService {
	@Autowired
	ICategoryRepository categoryRepository;
	Logger logger=LoggerFactory.getLogger(CategoryServiceImplement.class);
	@Override
	public CategoryDTO addCategory(Category category) {
		logger.info("Inside add category method");
		Category category1= categoryRepository.save(category);
		return CategoryUtils.convertToCategoryDto(category1);
	
	}
	@Override
	public CategoryDTO updateCategory(Category category) {
		logger.info("Inside update category method");
		Category category1= categoryRepository.save(category);
		return CategoryUtils.convertToCategoryDto(category1);
		
	}

	@Override
	public void removeCategory(String categoryId) {
		logger.info("Inside remove category method");
		 categoryRepository.deleteById(categoryId);
	}

	@Override
	
	public CategoryDTO viewCategoryById(String categoryId) {
		logger.info("Inside view category by category id method");
		Category category= categoryRepository.findById(categoryId).orElse(new Category());
		return CategoryUtils.convertToCategoryDto(category);
	
	}

	@Override
	public List<CategoryDTO> viewAllCategory() {
		logger.info("Inside view all category method");
		List<Category> list =categoryRepository.findAll();
	return CategoryUtils.convertToCategoryDtoList(list);
	
	}

}
