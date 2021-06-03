package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.Items;

public interface IItemRepository extends JpaRepository<Items, String> {

}
