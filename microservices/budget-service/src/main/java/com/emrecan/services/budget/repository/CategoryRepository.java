package com.emrecan.services.budget.repository;

import com.emrecan.services.budget.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  List<Category> findByUserId(String userId);
}
