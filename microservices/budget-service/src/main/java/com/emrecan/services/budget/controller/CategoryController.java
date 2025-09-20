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
  public ResponseEntity<CategoryDto> createCategory(CreateCategoryReq createCategoryReq) {
    return ResponseEntity.ok().body(categoryService.saveCategory(getUserId(), createCategoryReq));
  }

  // Accept deletionId in body because of generator bug
  @Override
  public ResponseEntity<Void> deleteCategory(DeleteResourceReq deleteResourceReq) {
    return CategoriesApi.super.deleteCategory(deleteResourceReq);
  }

  @Override
  public ResponseEntity<List<CategoryDto>> getCategories() {
    List<CategoryDto> categories = categoryService.getCategories(getUserId());

    return ResponseEntity.ok(categories);
  }

  @Override
  public ResponseEntity<CategoryDto> updateCategory(UpdateCategoryReq updateTransactionReq) {
    return CategoriesApi.super.updateCategory(updateTransactionReq);
  }
}
