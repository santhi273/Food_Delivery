package com.capg.foodonlinedelivery.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.FoodCart;

@Repository
public interface ICartRepository extends JpaRepository<FoodCart, Integer> {
	@Query("select c from FoodCart c where c.customer.customerId=:id")
	public FoodCart findCartByCustomerId(@Param("id") int customerId);

}
