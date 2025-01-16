package com.cts.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.ems.dto.EmployeeDto;
import com.cts.ems.entity.Employee;
import com.cts.ems.exception.ResourceNotFoundException;
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

	// Implements get By Id method.
	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId)
			.orElseThrow(()-> 
			new ResourceNotFoundException("Employee does not exist with a given id : "+ employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	// Implements get all employees method.
	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	// Implementing update employee method.
	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with given id: "+ employeeId)
		);
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	// Implementing the delete employee method.
	@Override
	public void deleteEmployee(Long employeeId) {
		// If employee with given id not exist then below code will throw resource not found error.
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with given id: "+ employeeId)
		);
		employeeRepository.deleteById(employeeId);
	}

}
