package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
