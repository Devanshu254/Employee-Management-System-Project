package com.cts.ems.service;

import com.cts.ems.dto.EmployeeDto;

public interface EmployeeService {
	// Create Employee Method which is used to create an employee in our project.
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	// Created Get Employee Method so that we can get all the employees which we have created.
	EmployeeDto getEmployeeById(Long employeeId);
}
