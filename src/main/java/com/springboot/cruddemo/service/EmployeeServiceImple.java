package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	 public EmployeeServiceImple(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theemployeeDAO) {
		 employeeDAO = theemployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional

	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional

	public void save(Employee theEmployee) {
		 employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional

	public void deleteById(int theId) {
		 employeeDAO.deleteById(theId);
	}

}
