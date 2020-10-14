package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	 public EmployeeDAOJpaImpl(EntityManager theentityManager) {
		 entityManager = theentityManager;
		
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee tempEmployee = entityManager.find(Employee.class, theId);
		return tempEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeID");
		theQuery.setParameter("employeeID", theId);
		theQuery.executeUpdate();

	}

}
