package com.cts.ems.service;

import com.cts.ems.dto.DepartmentDto;

public interface DepartmentService {
	// Created Create Department method within our interface.
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
	// Created getDepartment by Id method within our interface.
	DepartmentDto getDepartmentById(Long departmentId);
}
