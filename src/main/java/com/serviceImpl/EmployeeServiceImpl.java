package com.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exception.ResourceNotFoundException;
import com.entities.Employee;
import com.repository.EmployeeRepository;
import com.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee create(Employee employee) {
		return repository.save(employee);
		
	}

	@Override
	public List<Employee> retrive() {
		return repository.findAll();
	}

	@Override
	public Employee update(Employee employee, int id) {
		 Employee employee1 = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee ID not found"+id));
		employee1.setName(employee.getName());
		employee1.setAge(employee.getAge());
		employee1.setEmail(employee.getEmail());
		employee1.setLocation(employee.getLocation());
		 return repository.saveAndFlush(employee1);
	}

	@Override
	public Employee getById(int id) {
		Employee employee = repository.findById(null).orElseThrow(()-> new ResourceNotFoundException("Employee Id not Found "+id));
		return employee;
	}

	@Override
	public void deleteById(int id) {
		Employee employee = repository.findById(null).orElseThrow(()-> new ResourceNotFoundException("Employee Id not Found "+id));
		repository.delete(employee);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}
	
}
