package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {

}
