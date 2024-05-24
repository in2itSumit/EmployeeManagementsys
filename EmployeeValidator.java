package com.example.demo.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exceptionHandler.IllegalAgeException;
import com.example.demo.exceptionHandler.IllegalDateException;
import com.example.demo.exceptionHandler.IllegalNameException;
import com.example.demo.exceptionHandler.IllegalSalaryException;
import com.example.demo.exceptionHandler.Illegal_Id_Exception;
import com.example.demo.repo.EmployeeRepo;

@Component
public class EmployeeValidator {
	
	
	public String validateId(int id) throws Illegal_Id_Exception
	{
		
		if(id<=0)
		{
			throw new Illegal_Id_Exception("Wrong ID entered");
		}
		return "valid";
	}
	public String validateAge(int age) throws IllegalAgeException
	{
		if(age<18)
		{
			throw new IllegalAgeException("You are under age");
		}
		return "valid";
	}
	public String validateSalary(int salary) throws IllegalSalaryException
	{
		if(salary<=0)
		{
			throw new IllegalSalaryException("Wrong salary entered");
		}
		return "valid";
	}
	
	
	public String validateName(String name) throws IllegalNameException
	{
		for(int i=0;i<name.length();i++)
		{
			if(!(name.charAt(i)>='a'&& name.charAt(i)<='z' || name.charAt(i)>='A'&& name.charAt(i)<='Z'))
			{
				throw new IllegalNameException("Wrong Name entered");
			}
		}
		return "valid";
	}
	
	
	public String validateJDate(LocalDate jdate)throws IllegalDateException
	{
			
			LocalDate currDate=LocalDate.now();
			if(currDate.isAfter(jdate))
			{
				throw new IllegalDateException("Wrong Date entered");
				
			}
			
			return "valid";
	}
}
