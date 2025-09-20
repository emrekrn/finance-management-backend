package com.emrecan.services.budget.service;

import com.emrecan.services.budget.model.Category;
import com.emrecan.services.budget.model.CreateCategoryReq;
import java.util.List;

public interface CategoryService {

  List<Category> getCategories(String userId);

  Category saveCategory(String userId, CreateCategoryReq category);

  Category updateCategory(Category category);

  Category deleteCategory(Integer id);

  Category findCategoryById(Integer id);
}
