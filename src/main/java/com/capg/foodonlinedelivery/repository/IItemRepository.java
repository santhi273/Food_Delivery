package com.capg.foodonlinedelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.capg.foodonlinedelivery.entities.Items;

public interface IItemRepository extends JpaRepository<Items, String> {
	@Query("delete i from Items i where i.itemId=?1 ")
	public void deleteById(String itemId);
	
	public List<Items> findItemsByCategory(String name);

	public List<Items> findItemsByRestaurant(String name);

	public Optional<Items> findById(Integer id);

}
