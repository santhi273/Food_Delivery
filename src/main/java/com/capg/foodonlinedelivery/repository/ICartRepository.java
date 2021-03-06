package com.capg.foodonlinedelivery.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.FoodCart;

@Repository
public interface ICartRepository extends JpaRepository<FoodCart, Integer> {
	public FoodCart findByCustomer_CustomerId(int customerId);
}
