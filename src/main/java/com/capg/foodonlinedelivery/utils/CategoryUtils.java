package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.model.CategoryDTO;
public class CategoryUtils {
	public static List<CategoryDTO> convertToCategoryDtoList(List<Category> list){
		List<CategoryDTO> dtolist = new ArrayList<CategoryDTO>();
		for(Category Category : list) 
			dtolist.add(convertToCategoryDto(Category));
		return dtolist;
	}
	public static Category convertToCategory(CategoryDTO categorydto) {
		Category category = new Category();
		category.setCategoryId(categorydto.getCategoryId());
		category.setCategoryName(categorydto.getCategoryName());
		return category;
	}
		public static CategoryDTO convertToCategoryDto(Category category) {
			CategoryDTO categorydto = new CategoryDTO();
			categorydto.setCategoryId(category.getCategoryId());
			categorydto.setCategoryName(category.getCategoryName());
			return categorydto;
		}
		
	
}
