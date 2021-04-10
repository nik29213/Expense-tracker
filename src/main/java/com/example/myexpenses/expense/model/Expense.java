package com.example.myexpenses.expense.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="expense")
public class Expense {

	 @Id
	 private Long id;
	 
	 private String description;
	 
	 private Instant expensedateInstant;
	 
	 private String location;
	 
	 @ManyToOne
	 private Category category;
	 
	 @JsonIgnore
	 @ManyToOne
	 private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescript(String description) {
		this.description = description;
	}

	public Instant getExpensedateInstant() {
		return expensedateInstant;
	}

	public void setExpensedateInstant(Instant expensedateInstant) {
		this.expensedateInstant = expensedateInstant;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
