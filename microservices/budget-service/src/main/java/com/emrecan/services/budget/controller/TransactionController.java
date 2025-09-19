package com.emrecan.services.budget.controller;

import com.emrecan.services.budget.api.TransactionsApi;
import com.emrecan.services.budget.model.CreateTransactionReq;
import com.emrecan.services.budget.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api")
public class TransactionController implements TransactionsApi {

    @Override
    public ResponseEntity<Transaction> createTransaction(CreateTransactionReq createTransactionReq) {
        var id = new BigDecimal(ThreadLocalRandom.current().nextLong(1_000_000, 9_999_999));
        var created = new Transaction(
                id,
                createTransactionReq.getName(),
                createTransactionReq.getDate(),
                createTransactionReq.getCategory(),
                createTransactionReq.getAmount(),
                createTransactionReq.getNotes()
        );
        return ResponseEntity.ok(created);

    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    public ResponseEntity<List<Transaction>> getTransactions(LocalDate fromYear, LocalDate toYear, Double minAmount, Double maxAmount, String category, String receiver) {
        var transactions = List.of(
                new Transaction(new BigDecimal("1001"), "Salary - September", LocalDate.now().withDayOfMonth(1), "Income", 4200.00f, "Monthly salary"),
                new Transaction(new BigDecimal("1002"), "Groceries", LocalDate.now().minusDays(6), "Food", -145.75f, "Weekly grocery run"),
                new Transaction(new BigDecimal("1003"), "Electricity Bill", LocalDate.now().minusDays(10), "Utilities", -92.30f, "September bill"),
                new Transaction(new BigDecimal("1004"), "Coffee with Alex", LocalDate.now().minusDays(2), "Leisure", -8.50f, "Latte + croissant"),
                new Transaction(new BigDecimal("1005"), "Stock Dividend", LocalDate.now().minusDays(15), "Investment", 56.25f, "Quarterly dividend")
        );

        return ResponseEntity.ok(transactions);
    }

}
