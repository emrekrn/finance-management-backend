package com.emrecan.services.budget.controller;

import com.emrecan.services.budget.api.CategoriesApi;
import com.emrecan.services.budget.model.*;
import com.emrecan.services.budget.service.CategoryService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController extends BaseController implements CategoriesApi {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public ResponseEntity<CategoryEntry> createCategory(CreateCategoryReq createCategoryReq) {
    return ResponseEntity.ok().body(categoryService.saveCategory(getUserId(), createCategoryReq));
  }

  @Override
  public ResponseEntity<Void> deleteCategory(Integer id) {
    return CategoriesApi.super.deleteCategory(id);
  }

  @Override
  public ResponseEntity<List<CategoryEntry>> getCategories() {
    List<CategoryEntry> categories = categoryService.getCategories(getUserId());

    return ResponseEntity.ok(categories);
  }

  @Override
  public ResponseEntity<CategoryEntry> updateCategory(UpdateCategoryReq updateTransactionReq) {
    return CategoriesApi.super.updateCategory(updateTransactionReq);
  }
}
