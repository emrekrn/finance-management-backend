package com.emrecan.services.budget.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetController {

    @GetMapping("/budget")
    public String getBudget() {
        return "This is budget service";
    }
}
