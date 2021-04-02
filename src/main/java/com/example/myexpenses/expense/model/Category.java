package com.example.myexpenses.expense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="category")
public class Category {
	
	@Id
	private Long id;
	
	private String name;

	
	
	
	
	
	
}
