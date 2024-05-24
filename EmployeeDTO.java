package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeeDTO {
	
	private int e_id;
	private String e_first_name;
	private String e_last_name;
	private LocalDate joining_date;
	private int e_salary;
	private int e_age;
	
}
