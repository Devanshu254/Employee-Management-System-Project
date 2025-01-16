package com.cts.ems.service;

import com.cts.ems.dto.EmployeeDto;

public interface EmployeeService {
	// Create Employee Method which is used to create an employee in our project.
	EmployeeDto createEmployee(EmployeeDto employeeDto);
}
