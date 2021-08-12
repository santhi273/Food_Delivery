package com.capg.foodonlinedelivery.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.CategoryDTO;
import com.capg.foodonlinedelivery.repository.ICategoryRepository;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.utils.CategoryUtils;
/**
 * 
 * @author: santhi
 * Description:category service implementation
 * date: 7/6/2021
 * param:category entity
 *
 */
@Service
public class CategoryServiceImplement implements ICategoryService {
	@Autowired
	ICategoryRepository categoryRepository;
	@Autowired
	IItemRepository itemRepository;
	@Autowired
	ICartService cartService;
	Logger logger=LoggerFactory.getLogger(CategoryServiceImplement.class);
	/**
	 * 
	 * @author: santhi
	 * Description:add category
	 * date: 7/6/2021
	 * param:category entity,
	 *return :category dto
	 */
	@Override
	public CategoryDTO addCategory(Category category) {
		logger.info("Inside add category method");
		Category category1= categoryRepository.save(category);
		return CategoryUtils.convertToCategoryDto(category1);
	
	}
	/**
	 * 
	 * @author: santhi
	 * Description:update category
	 * date: 7/6/2021
	 * param:category entity,
	 *return :category dto
	 */
	@Override
	public CategoryDTO updateCategory(Category category) {
		logger.info("Inside update category method");
		Category category1= categoryRepository.save(category);
		return CategoryUtils.convertToCategoryDto(category1);
		
	}
	/**
	 * 
	 * @author: santhi
	 * Description:remove category
	 * date: 7/6/2021
	 * param:category entity,
	 *return :void
	 */
	@Override
	public void removeCategory(Integer categoryId) {
		logger.info("Inside remove category method");
		Category category=categoryRepository.findById(categoryId).orElse(null);
		List<Items> item=itemRepository.findItemsByCategory(category.getCategoryName());
		for(int i=0;i<item.size();i++) {
			item.get(i).setCategory(null);
		}
		itemRepository.saveAll(item);
		 categoryRepository.deleteById(categoryId);
	}
	/**
	 * 
	 * @author: santhi
	 * Description:view category
	 * date: 7/6/2021
	 * param:category entity,
	 *return :categorydto
	 */
	@Override
	public CategoryDTO viewCategoryById(Integer categoryId) {
		logger.info("Inside view category by category id method");
		Category category= categoryRepository.findById(categoryId).orElse(null);
		if(category==null) {
			return null;
		}else {
		return CategoryUtils.convertToCategoryDto(category);
		}
	}
	/**
	 * 
	 * @author: santhi
	 * Description:view category
	 * date: 7/6/2021
	 * param:category entity,
	 *return :list<categorydto>
	 */
	@Override
	public List<CategoryDTO> viewAllCategory() {
		logger.info("Inside view all category method");
		List<Category> list =categoryRepository.findAll();
	return CategoryUtils.convertToCategoryDtoList(list);
	
	}

}
