package com.emrecan.services.budget.controller;

import com.emrecan.services.budget.api.TransactionsApi;
import com.emrecan.services.budget.model.Category;
import com.emrecan.services.budget.model.CreateTransactionReq;
import com.emrecan.services.budget.model.Transaction;
import com.emrecan.services.budget.model.UpdateTransactionReq;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class TransactionController implements TransactionsApi {

    @Override
    public ResponseEntity<Transaction> createTransaction(CreateTransactionReq createTransactionReq) {
        var created = new Transaction(
                1,
                createTransactionReq.getName(),
                createTransactionReq.getDate(),
                createTransactionReq.getCategory(),
                createTransactionReq.getAmount(),
                createTransactionReq.getNotes()
        );
        return ResponseEntity.ok(created);

    }

    @Override
    public ResponseEntity<Void> deleteTransaction(Integer transactionId) {
        return TransactionsApi.super.deleteTransaction(transactionId);
    }

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(LocalDate fromYear, LocalDate toYear, Double minAmount, Double maxAmount, Category category, String receiver) {
        var transactions = List.of(
                new Transaction(1, "Salary - September", LocalDate.now().withDayOfMonth(1), new Category(), 4200.00f, "Monthly salary"),
                new Transaction(2, "Groceries", LocalDate.now().minusDays(6), new Category(), -145.75f, "Weekly grocery run"),
                new Transaction(3, "Electricity Bill", LocalDate.now().minusDays(10), new Category(), -92.30f, "September bill"),
                new Transaction(4, "Coffee with Alex", LocalDate.now().minusDays(2), new Category(), -8.50f, "Latte + croissant"),
                new Transaction(5, "Stock Dividend", LocalDate.now().minusDays(15), new Category(), 56.25f, "Quarterly dividend")
        );
        return ResponseEntity.ok(transactions);
    }

    @Override
    public ResponseEntity<Transaction> updateTransaction(UpdateTransactionReq updateTransactionReq) {
        return TransactionsApi.super.updateTransaction(updateTransactionReq);
    }
}
