package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController( EmployeeService theemployeeService)
	{
		employeeService=theemployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployee(@PathVariable int employeeID)
	{
		Employee theEmplpyee = employeeService.findById(employeeID);
		
		if(theEmplpyee== null)
		{
			throw new RuntimeException("Employee id not found - "+employeeID);
		}
		
		return theEmplpyee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployee(@PathVariable int employeeID)
	{
		Employee theEmployee = employeeService.findById(employeeID);
		if(theEmployee==null)
		{
			throw new RuntimeException("the employee id is not found - "+employeeID);
		}
		employeeService.deleteById(employeeID);
		
		return "Deleted the employee by id "+employeeID;
	}
	

}
