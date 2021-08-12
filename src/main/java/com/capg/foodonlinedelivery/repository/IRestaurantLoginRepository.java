package com.capg.foodonlinedelivery.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.RestaurantLogin;

@Repository
public interface IRestaurantLoginRepository extends JpaRepository<RestaurantLogin, Integer>{
	public RestaurantLogin findByUserName(String userName);

}
