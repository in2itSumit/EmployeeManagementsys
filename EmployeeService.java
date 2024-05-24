package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exceptionHandler.DataNotExistException;
import com.example.demo.repo.EmployeeRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeService {
	@Autowired
	private EmployeeRepo emprepo;
	
	public Boolean saveEmp(EmployeeDTO emp) {
		Employee emp1=new Employee();
		emp1.setE_age(emp.getE_age());
		emp1.setE_id(emp.getE_id());
		emp1.setE_first_name(emp.getE_first_name());
		emp1.setE_last_name(emp.getE_last_name());
		emp1.setE_salary(emp.getE_salary());
		emp1.setJoining_date(emp.getJoining_date());
		try {
		emprepo.save(emp1);
		return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	public EmployeeDTO fetchEmpById(int id) throws DataNotExistException {
			try
			{
			Employee emp=emprepo.getById(id);
			EmployeeDTO emp1=new EmployeeDTO();
			emp1.setE_age(emp.getE_age());
			emp1.setE_id(emp.getE_id());
			emp1.setE_first_name(emp.getE_first_name());
			emp1.setE_last_name(emp.getE_last_name());
			emp1.setE_salary(emp.getE_salary());
			emp1.setJoining_date(emp.getJoining_date());
			return emp1;
			}
			catch(Exception ex)
			{
				throw new DataNotExistException("Employee with id "+id+" does not exist");
			}
	}
	public List<EmployeeDTO> fetchAll() throws DataNotExistException {

		List<EmployeeDTO> employees=new ArrayList<>();
		
			List<Employee> allEmployees=emprepo.findAll();
			if(allEmployees==null)throw new DataNotExistException("There are not any records for Employees");
			for(Employee emp:allEmployees)
			{
				EmployeeDTO emp1=new EmployeeDTO();
				emp1.setE_age(emp.getE_age());
				emp1.setE_id(emp.getE_id());
				emp1.setE_first_name(emp.getE_first_name());
				emp1.setE_salary(emp.getE_salary());
				emp1.setJoining_date(emp.getJoining_date());
				employees.add(emp1);
			}
			return employees;
		
	}
	public Boolean updateSalary(int id,int salary) throws DataNotExistException {
		Employee emp=emprepo.getById(id);
		if(emp==null)
		throw new DataNotExistException("Employee with id "+id+" does not exist");
		
		emp.setE_salary(salary);
		emprepo.save(emp);
		return true;
		
	}
	public Boolean updateAge(int id,int age) throws DataNotExistException {
		Employee emp=emprepo.getById(id);
		if(emp==null)
		throw new DataNotExistException("Employee with id "+id+" does not exist");
			emp.setE_age(age);
			emprepo.save(emp);
			
		
		return true;
	}
	
	public Boolean deleteEmp(int id) throws DataNotExistException {
		try {
			emprepo.deleteById(id);
		}catch(Exception ex)
		{
			throw new DataNotExistException("Employee with id "+id+" does not exist");
		}
			return true;
		
	}
	
}
