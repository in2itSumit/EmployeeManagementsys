package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@Column(name="e_id")
	private int e_id;
	@Column(name="e_first_name")
	private String e_first_name;
	@Column(name="e_last_name")
	private String e_last_name;
	@Column(name="joining_date")
	private LocalDate joining_date;
	@Column(name="e_salary")
	private int e_salary;
	@Column(name="e_age")
	private int e_age;
	
	
	

	
}
