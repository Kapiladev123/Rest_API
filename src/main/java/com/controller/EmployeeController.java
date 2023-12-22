package com.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Employee;
import com.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
		Employee create = service.create(employee);
		return new ResponseEntity<Employee>(create,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> list = service.retrive();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee,@PathVariable int id){
		return new ResponseEntity<Employee>(service.update(employee, id),HttpStatus.OK);
	}
	
	@PatchMapping("/employees/{id}")
	public ResponseEntity<Employee> patchEmployee(@Valid @RequestBody Employee employee,@PathVariable int id){
		return new ResponseEntity<Employee>(service.update(employee, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		service.deleteById(id);
		return new ResponseEntity<String>("data deleted",HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<String> deleteEmployees(){
		service.deleteAll();
		return new ResponseEntity<String>("All Data deleted",HttpStatus.OK);
	}
}
