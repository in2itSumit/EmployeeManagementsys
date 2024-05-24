package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exceptionHandler.DataNotExistException;
import com.example.demo.exceptionHandler.IllegalAgeException;
import com.example.demo.exceptionHandler.IllegalDateException;
import com.example.demo.exceptionHandler.IllegalNameException;
import com.example.demo.exceptionHandler.IllegalSalaryException;
import com.example.demo.exceptionHandler.Illegal_Id_Exception;
import com.example.demo.service.EmployeeService;
import com.example.demo.validate.EmployeeValidator;

@RestController
@RequestMapping("/emp/services")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private EmployeeValidator validator;
	
	
	@PostMapping("/create")
	public String createEmployee(@RequestBody EmployeeDTO emp) throws IllegalAgeException //c
, Illegal_Id_Exception, IllegalNameException, IllegalDateException, IllegalSalaryException
	{
		validator.validateId(emp.getE_id());
		
//		if(val.equals("invalid"))
//		{
//			return "Id is invalid";
//		}
		
		validator.validateName(emp.getE_first_name());
//		if(val.equals("invalid"))
//		{
//			return "Name is invalid";
//		}
		
		validator.validateName(emp.getE_last_name());
//		if(val.equals("invalid"))
//		{
//			return "Name is invalid";
//		}
//		
		
		validator.validateJDate(emp.getJoining_date());
//		if(val.equals("invalid"))
//		{
//			return "Joining Date is invalid";
//		}
//		
		
		validator.validateSalary(emp.getE_salary());
//		if(val.equals("invalid"))
//		{
//			return "Salary is invalid";
//		}
//		
		
		validator.validateAge(emp.getE_age());
//		if(val.equals("invalid"))
//		{
//			return "Age is invalid";
//		}
		
		Boolean b=empService.saveEmp(emp);
		if(b==true)return "Employee Added Successfully";	
		else return "Employee not added";
	}
	
	@GetMapping("/byId")
	public Object fetchEmpById(@RequestBody EmployeeDTO emp) throws Illegal_Id_Exception, DataNotExistException //r

	{		
		String val=validator.validateId(emp.getE_id());
//		if(val.equals("invalid"))
//		{
//			return "Id is invalid";
//		}
		EmployeeDTO emp1=empService.fetchEmpById(emp.getE_id());
//		if(emp1==null)
//		{
//			return "Employee with "+emp.getE_id()+" is not present";
//		}
		return emp1;
	}
	
	@GetMapping("/all")
	public Object fetchAll() throws DataNotExistException //r
	{
		 List<EmployeeDTO> empList=empService.fetchAll();
//		 if(empList==null)
//			{
//				return "There is no any employee";
//			}
		return empList;	
	}
	
	@PutMapping("/updateSal")
	public String updateSalary(@RequestBody EmployeeDTO emp) throws Illegal_Id_Exception, IllegalSalaryException //u
, DataNotExistException
	{
		EmployeeDTO emp1=empService.fetchEmpById(emp.getE_id());
//		if(emp1==null)
//		{
//			return "Employee with "+emp.getE_id()+" is not present";
//		}
		
		String val=validator.validateId(emp.getE_id());
//		if(val.equals("invalid"))
//		{
//			return "Id is invalid";
//		}
		val=validator.validateSalary(emp.getE_salary());
//		if(val.equals("invalid"))
//		{
//			return "Salary is invalid";
//		}
		Boolean b=empService.updateSalary(emp.getE_id(),emp.getE_salary());
		if(b==true)return "Salary updated successfully";
		else return "Salary did not updated";
	}
	
	@PutMapping("/updateAge")
	public String updateAge(@RequestBody EmployeeDTO emp) throws Illegal_Id_Exception, IllegalAgeException //u
, DataNotExistException

	{
		EmployeeDTO emp1=empService.fetchEmpById(emp.getE_id());
//		if(emp1==null)
//		{
//			return "Employee with "+emp.getE_id()+" is not present";
//		}
//		
		String val=validator.validateId(emp.getE_id());
//		if(val.equals("invalid"))
//		{
//			return "Id is invalid";
//		}
		val=validator.validateAge(emp.getE_age());
//		if(val.equals("invalid"))
//		{
//			return "Age is invalid";
//		}
		Boolean b=empService.updateAge(emp.getE_id(),emp.getE_age());
		if(b==true)return "Age updated successfully";
		else return "Age did not updated";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmp(@RequestBody EmployeeDTO emp) throws Illegal_Id_Exception //d
, DataNotExistException
	{
		String val=validator.validateId(emp.getE_id());
//		if(val.equals("invalid"))	
//		{
//			return "Id is invalid";
//		}
		
		EmployeeDTO emp1=empService.fetchEmpById(emp.getE_id());
		if(emp1==null)
		{
			throw new DataNotExistException("Employee with id "+emp.getE_id()+"does not exist");
			
		}
//		else
//		{
			empService.deleteEmp(emp.getE_id());
			return "Employee with "+emp.getE_id()+" deleted Successfully";
//		}
		
		
	}
}
