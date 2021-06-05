package com.capg.foodonlinedelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.foodonlinedelivery.entities.Items;

public interface IItemRepository extends JpaRepository<Items, Integer> {


	
	public List<Items> findItemsByCategory(String name);

	public List<Items> findItemsByRestaurant(String name);

	public void deleteById(String itemId);




	

}
