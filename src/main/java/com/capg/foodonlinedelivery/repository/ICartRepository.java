package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.FoodCart;

public interface ICartRepository extends JpaRepository<FoodCart, String> {

}
