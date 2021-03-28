package com.example.myexpenses.expense.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="category")

public class Category {
	@Id
	private Long id;
	
	private String name;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;
	
}
