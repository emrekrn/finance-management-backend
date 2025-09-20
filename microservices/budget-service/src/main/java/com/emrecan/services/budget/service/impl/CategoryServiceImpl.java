package com.emrecan.services.budget.service.impl;

import com.emrecan.services.budget.mapper.CategoryMapper;
import com.emrecan.services.budget.model.*;
import com.emrecan.services.budget.repository.CategoryRepository;
import com.emrecan.services.budget.service.CategoryService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public List<CategoryDto> getCategories(String userId) {
    List<CategoryDto> categories =
        CategoryMapper.INSTANCE.mapCategoriesToDtos(this.categoryRepository.findByUserId(userId));
    return categories;
  }

  @Override
  public CategoryDto saveCategory(String userId, CreateCategoryReq createCategoryReq) {
    Category category = CategoryMapper.INSTANCE.mapSaveRequestToCategory(userId, createCategoryReq);
    Category createdCategory = this.categoryRepository.saveAndFlush(category);

    log.info(
        "Created category with id {} and name {}",
        createdCategory.getId(),
        createdCategory.getName());
    return CategoryMapper.INSTANCE.mapCategoryToDto(createdCategory);
  }

  @Override
  public CategoryDto updateCategory(UpdateCategoryReq updateCategoryReq) {
    return null;
  }

  @Override
  public CategoryDto deleteCategory(Integer id) {
    return null;
  }

  @Override
  public CategoryDto findCategoryById(Integer id) {
    return null;
  }
}
