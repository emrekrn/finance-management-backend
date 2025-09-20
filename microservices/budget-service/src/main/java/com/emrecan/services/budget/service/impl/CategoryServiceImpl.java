package com.emrecan.services.budget.service.impl;

import com.emrecan.services.budget.model.*;
import com.emrecan.services.budget.model.core.TransactionTypeEnum;
import com.emrecan.services.budget.repository.CategoryRepository;
import com.emrecan.services.budget.service.CategoryService;
import java.util.ArrayList;
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
  public List<CategoryEntry> getCategories(String userId) {
    List<CategoryEntry> categories = new ArrayList<>();
    this.categoryRepository
        .findByUserId(userId)
        .forEach(
            category -> {
              categories.add(
                  new CategoryEntry(
                      category.getId(),
                      category.getName(),
                      TransactionType.INCOME,
                      category.getColor(),
                      category.getTransactions()));
            });
    return categories;
  }

  @Override
  public CategoryEntry saveCategory(String userId, CreateCategoryReq category) {
    Category entry =
        Category.builder()
            .name(category.getName())
            .type(TransactionTypeEnum.INCOME)
            .color(category.getColor())
            .userId(userId)
            .build();
    Category createdEntry = this.categoryRepository.saveAndFlush(entry);

    CategoryEntry createdCategory =
        new CategoryEntry(
            createdEntry.getId(),
            createdEntry.getName(),
            TransactionType.INCOME,
            createdEntry.getColor(),
            createdEntry.getTransactions());

    log.info(
        "Created category with id {} and name {}",
        createdCategory.getId(),
        createdCategory.getName());
    return createdCategory;
  }

  @Override
  public CategoryEntry updateCategory(CategoryEntry category) {
    return null;
  }

  @Override
  public CategoryEntry deleteCategory(Integer id) {
    return null;
  }

  @Override
  public CategoryEntry findCategoryById(Integer id) {
    return null;
  }
}
