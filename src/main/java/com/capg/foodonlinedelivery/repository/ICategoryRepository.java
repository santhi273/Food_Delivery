package com.capg.foodonlinedelivery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.foodonlinedelivery.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {
	
}
