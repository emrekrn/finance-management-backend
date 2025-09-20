package com.emrecan.services.budget.service;

import com.emrecan.services.budget.model.CategoryDto;
import com.emrecan.services.budget.model.CreateCategoryReq;
import com.emrecan.services.budget.model.UpdateCategoryReq;
import java.util.List;

public interface CategoryService {

  List<CategoryDto> getCategories(String userId);

  CategoryDto saveCategory(String userId, CreateCategoryReq createCategoryReq);

  CategoryDto updateCategory(UpdateCategoryReq updateCategoryReq);

  CategoryDto deleteCategory(Integer id);

  CategoryDto findCategoryById(Integer id);
}
