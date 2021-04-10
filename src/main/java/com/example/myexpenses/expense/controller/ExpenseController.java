package com.example.myexpenses.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myexpenses.expense.model.Expense;
import com.example.myexpenses.expense.repository.ExpenseRepository;

@RestController
@RequestMapping("/api/v1")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }
    @GetMapping("/expense/{id}")
    Optional<?> getExpenses(@PathVariable Long id) {
        return expenseRepository.findById(id);
    }
    
    @DeleteMapping("/expense/{id}") 
    ResponseEntity<?> deleteExpense(@PathVariable Long id) {
    	
    	expenseRepository.deleteById(id);
    	return ResponseEntity.ok().build();
    }
    
    @PostMapping("/expenses") 
    ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) throws URISyntaxException{
    	Expense newexpense = expenseRepository.save(expense);
    	return ResponseEntity.created(new URI("/api/v1/expense" + newexpense.getId())).body(newexpense);
    	
    }
	
    
    
}
