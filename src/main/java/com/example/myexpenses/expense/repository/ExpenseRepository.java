package com.example.myexpenses.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myexpenses.expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
