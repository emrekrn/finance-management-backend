package com.emrecan.services.budget.controller;

import com.emrecan.services.budget.api.CategoriesApi;
import com.emrecan.services.budget.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController implements CategoriesApi {

    @Override
    public ResponseEntity<Category> createCategory(CreateCategoryReq createCategoryReq) {
        return CategoriesApi.super.createCategory(createCategoryReq);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Integer id) {
        return CategoriesApi.super.deleteCategory(id);
    }

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        var categories = List.of(
                new Category(1, "Salary", TransactionType.INCOME, "#ffffff"),
                new Category(2, "Rent", TransactionType.INCOME, "#ffffff"),
                new Category(3, "Housing", TransactionType.OUTCOME, "#ffffff"),
                new Category(4, "Investments", TransactionType.OUTCOME, "#ffffff"),
                new Category(5, "Paypal", TransactionType.OUTCOME, "#ffffff")
        );
        return ResponseEntity.ok(categories);
    }

    @Override
    public ResponseEntity<Category> updateCategory(UpdateCategoryReq updateTransactionReq) {
        return CategoriesApi.super.updateCategory(updateTransactionReq);
    }
}
