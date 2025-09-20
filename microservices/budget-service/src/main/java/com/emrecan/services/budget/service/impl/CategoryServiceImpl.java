package com.emrecan.services.budget.service.impl;

import com.emrecan.services.budget.model.Category;
import com.emrecan.services.budget.model.CategoryEntry;
import com.emrecan.services.budget.model.CreateCategoryReq;
import com.emrecan.services.budget.model.TransactionType;
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
  public List<Category> getCategories(String userId) {
    List<Category> categories = new ArrayList<>();
    this.categoryRepository
        .findByUserId(userId)
        .forEach(
            category -> {
              categories.add(
                  new Category(
                      category.getId(),
                      category.getName(),
                      TransactionType.INCOME,
                      category.getColor(),
                      category.getTransactions()));
            });
    return categories;
  }

  @Override
  public Category saveCategory(String userId, CreateCategoryReq category) {
    CategoryEntry entry =
        CategoryEntry.builder()
            .name(category.getName())
            .type(TransactionTypeEnum.INCOME)
            .color(category.getColor())
            .userId(userId)
            .build();
    CategoryEntry createdEntry = this.categoryRepository.saveAndFlush(entry);

    Category createdCategory =
        new Category(
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
  public Category updateCategory(Category category) {
    return null;
  }

  @Override
  public Category deleteCategory(Integer id) {
    return null;
  }

  @Override
  public Category findCategoryById(Integer id) {
    return null;
  }
}
