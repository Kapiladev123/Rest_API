package com.entities;

import org.hibernate.validator.constraints.Range;

import com.Audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private int id;
	
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]+$", message = "enter only alphabetic charecters")
	@Column(name = "EmployeeName")
	private String name;
	
	
	@Range(min=1, max=100)
	@Column(name = "EmployeeAge")
	private int age;
	
	@NotBlank
	@Email(message = "enter correct email id")
	@Column(name = "EmployeeEmail")
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]+$", message = "enter only alphabetic charecters")
	@Column(name = "EmployeeLocation",nullable = false)
	private String location;
}
