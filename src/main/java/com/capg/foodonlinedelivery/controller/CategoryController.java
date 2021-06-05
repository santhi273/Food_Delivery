package com.capg.foodonlinedelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.model.CategoryDTO;
import com.capg.foodonlinedelivery.service.ICategoryService;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
	@Autowired
	ICategoryService service;
	
	@PostMapping(value = "/add", consumes = {"application/json"}, produces = {"application/json"})
	public CategoryDTO addCategory(Category category) {
		
		return service.addCategory(category);
	}
	
	@PutMapping(value = "/update")
	public CategoryDTO updateCategory(Category category) {
		
		return service.updateCategory(category);
	}
	
	@GetMapping(value = "/get/{Id}")
	public CategoryDTO viewCategoryById(String categoryId) {
		
		return service.viewCategoryById(categoryId);
	}
	
	@DeleteMapping(value = "/delete")
	public void removeCategory(Category category) {
		
		 service.removeCategory(category);
		 
	}	 
	
	@GetMapping(value = "/get/Category")
	public List<CategoryDTO> viewAllCategory(){
		
		return service.viewAllCategory();
	}

    }
