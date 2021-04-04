package com.example.myexpenses.expense.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="expense")
public class Expense {

	 @Id
	 private Long id;
	 
	 private Instant expensedateInstant;
	 
	 private String descript;
	 
	
	 
	 @ManyToOne
	 private Category category;
	 
	 @ManyToOne
	 private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getExpensedateInstant() {
		return expensedateInstant;
	}

	public void setExpensedateInstant(Instant expensedateInstant) {
		this.expensedateInstant = expensedateInstant;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 
	 
	 
}
