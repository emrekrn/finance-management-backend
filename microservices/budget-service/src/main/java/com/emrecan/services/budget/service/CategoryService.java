package com.emrecan.services.budget.service;

import com.emrecan.services.budget.model.CategoryEntry;
import com.emrecan.services.budget.model.CreateCategoryReq;
import java.util.List;

public interface CategoryService {

  List<CategoryEntry> getCategories(String userId);

  CategoryEntry saveCategory(String userId, CreateCategoryReq category);

  CategoryEntry updateCategory(CategoryEntry category);

  CategoryEntry deleteCategory(Integer id);

  CategoryEntry findCategoryById(Integer id);
}
