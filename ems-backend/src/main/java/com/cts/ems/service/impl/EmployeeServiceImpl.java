package com.cts.ems.service.impl;

import org.springframework.stereotype.Service;

import com.cts.ems.dto.EmployeeDto;
import com.cts.ems.entity.Employee;
import com.cts.ems.mapper.EmployeeMapper;
import com.cts.ems.repository.EmployeeRepository;
import com.cts.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	// Implements Create Employee method which creates a method in our project.
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

}
