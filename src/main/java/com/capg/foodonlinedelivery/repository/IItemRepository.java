package com.capg.foodonlinedelivery.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.capg.foodonlinedelivery.entities.Items;


public interface IItemRepository extends JpaRepository<Items, Integer> {

	
	@Query("delete i from Items i where i.itemId=?1 ")
	public void deleteById(String itemId);
	
	@Query("select i from Item i inner join Restaurant r on "
		+ "i.restaurant.restaurantId = r.restaurantId where r.restaurantName =:name")
	public List<Items> findItemsByRestaurant(String name);


}

