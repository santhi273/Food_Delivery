package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, String> {

}
