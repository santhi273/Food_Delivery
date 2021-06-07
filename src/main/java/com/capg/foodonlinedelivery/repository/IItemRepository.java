package com.capg.foodonlinedelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.capg.foodonlinedelivery.entities.Items;

public interface IItemRepository extends JpaRepository<Items, Integer> {

	List<Items> findItemsByRestaurant(String restaurantName);

	
	@Query("select i from Item i inner join Category c"
		+ " on i.category.catId=c.catId where c.categoryName=:name")


public interface IItemRepository extends JpaRepository<Items, String> {
	@Query("delete i from Items i where i.itemId=?1 ")
	public void deleteById(String itemId);
	
	public List<Items> findItemsByCategory(String name);
	@Query("select i from Item i inner join Restaurant r on "
		+ "i.restaurant.restaurantId = r.restaurantId where r.restaurantName =:name")
	public List<Items> findItemsByRestaurant(String name);

<<<<<<< HEAD

=======
	public Optional<Items> findById(Integer id);
>>>>>>> 01527a6a88158c5b042661ed8b9c128862be598c

}
