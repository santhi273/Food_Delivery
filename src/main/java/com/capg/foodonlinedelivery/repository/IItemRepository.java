package com.capg.foodonlinedelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.Items;
@Repository
public interface IItemRepository extends JpaRepository<Items, Integer> {

	@Query("select i from Items i inner join Category c on"
			+ " i.category.categoryId=c.categoryId where c.categoryName=:name")
	public List<Items> findItemsByCategory(@Param("name") String name);

	@Query("delete from Items i where i.itemId=:itemId")
	public void deleteById(@Param("itemId") Integer itemId);

	@Query("select i from Items i where i.itemId=:itemId")
	public Items findByItemId(@Param("itemId") Integer itemId);
	public List<Items> findByRestaurantList_RestaurantName(String name);

}
