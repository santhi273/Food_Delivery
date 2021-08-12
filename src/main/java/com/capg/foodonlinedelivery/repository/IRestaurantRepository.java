package com.capg.foodonlinedelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
	public List<Restaurant> findByItemList_ItemName(String itemName);

	@Query(value = "select * from restaurant res inner join address a on res.add_id = a.address_id where a.area =:area", nativeQuery = true)
	public List<Restaurant> viewNearByRestaurant(@Param("area") String location);


}
