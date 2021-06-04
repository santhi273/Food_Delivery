package com.capg.foodonlinedelivery.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.repository.ICategoryRepository;
@Service
public class CategoryServiceImplement implements ICategoryService {
	@Autowired
	ICategoryRepository repo;
	@Override
	public Category addCategory(Category category) {

		return repo.save(category);
	}
	
	@Override
	public Category updateCategory(Category category) {

		return repo.save(category);
	}

	@Override
	public void removeCategory(Category category) {

		 repo.delete(category);
	}

	@Override
	
	public Category viewCategoryById(String categoryId) {

		return repo.findById(categoryId).orElse(new Category());
	}

	@Override
	public List<Category> viewAllCategory() {
		List<Category> list = new ArrayList();
			list=	repo.findAll();
		return list;
	}

}
