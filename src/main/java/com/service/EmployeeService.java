package com.service;

import java.util.List;

import com.entities.Employee;

public interface EmployeeService {

	Employee create(Employee employee);
	
	List<Employee> retrive();
	
	Employee update(Employee employee, int id);
	
	Employee getById(int id);
	
	void deleteById(int id);
	void deleteAll();
}
