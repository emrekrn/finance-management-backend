package com.emrecan.services.budget.controller;

import com.emrecan.services.budget.records.TestRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BudgetController {

    private static final Logger log = LoggerFactory.getLogger(BudgetController.class);

    @GetMapping("/api/budget")
    @PreAuthorize("hasAuthority('SCOPE_Admin')")
    public ResponseEntity<List<TestRecord>> getBudget(@AuthenticationPrincipal Jwt jwt) {
        String subject = jwt.getClaimAsString("username");
        log.info("GET /budget requested by sub={}", subject);
        var userRoles = jwt.getClaim("cognito:groups");
        log.debug("User roles: {}", userRoles);
        TestRecord record = new TestRecord("emr", "username comes from Cognito");
        return ResponseEntity.ok(List.of(record));
    }
}
