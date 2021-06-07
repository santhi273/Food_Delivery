package com.capg.foodonlinedelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.FoodCart;

@Repository
public interface ICartRepository extends JpaRepository<FoodCart, String> {

	public String findCartByCustomerId(int customerId);

	public Optional<FoodCart> findById(FoodCart cartId);

}
