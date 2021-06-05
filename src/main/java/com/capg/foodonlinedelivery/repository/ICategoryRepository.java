package com.capg.foodonlinedelivery.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.foodonlinedelivery.entities.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {
	public Optional<Category> findById(String categoryId);
	public List<Category> findAll(Category category);

}
