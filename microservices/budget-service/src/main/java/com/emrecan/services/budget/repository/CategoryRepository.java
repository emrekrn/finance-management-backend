package com.emrecan.services.budget.repository;

import com.emrecan.services.budget.model.CategoryEntry;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntry, Integer> {

  List<CategoryEntry> findByUserId(String userId);
}
