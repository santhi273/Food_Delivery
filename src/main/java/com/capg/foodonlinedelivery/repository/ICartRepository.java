package com.capg.foodonlinedelivery.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.FoodCart;

@Repository
public interface ICartRepository extends JpaRepository<FoodCart, String> {

	@Query("select c.cartId from FoodCart c where c.customer.customerId=?1")
	public FoodCart findCartByCustomerId(int customerId);

}
