package com.capg.foodonlinedelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.exceptionhandler.IdNotFoundException;
import com.capg.foodonlinedelivery.exceptionhandler.RemoveFailedException;
import com.capg.foodonlinedelivery.model.CategoryDTO;
import com.capg.foodonlinedelivery.service.ICategoryService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Category")
public class CategoryController {
	@Autowired
	ICategoryService service;
	Logger logger=LoggerFactory.getLogger(CategoryController.class);
	@PostMapping(value = "/add")

	public CategoryDTO addCategory(@RequestBody Category category) {
		logger.info("Inside add category Controller method");
		return service.addCategory(category);
	}

	@PutMapping(value = "/update")

	public CategoryDTO updateCategory(@Valid @RequestBody Category category) throws IdNotFoundException {
		logger.info("Inside add category Controller method");
		
		CategoryDTO category1=service.viewCategoryById(category.getCategoryId());
		if(category1==null) {
			logger.error("Exception");
			throw new IdNotFoundException("Invalid category for update !");
		}
		return service.updateCategory(category);
	}

	@GetMapping(value = "/get/{categoryId}")

	public CategoryDTO viewCategoryById(@PathVariable Integer categoryId) throws IdNotFoundException {
		logger.info("Inside view category By Id Controller method");
		CategoryDTO category1=service.viewCategoryById(categoryId);
		if(category1==null) {
			throw new IdNotFoundException("Delete category failed !");
		}
		return category1;
	}

	@DeleteMapping(value = "/delete/{categoryId}")
	public void removeCategory(@PathVariable Integer categoryId) throws RemoveFailedException{
		logger.info("Inside remove category Controller method");
		CategoryDTO category1=service.viewCategoryById(categoryId);
		if(category1==null) {
			throw new RemoveFailedException("Category id not found !");
		}
		service.removeCategory(categoryId);

	}

	@GetMapping(value = "/get/Category")
	public List<CategoryDTO> viewAllCategory() {

		return service.viewAllCategory();
	}

}
