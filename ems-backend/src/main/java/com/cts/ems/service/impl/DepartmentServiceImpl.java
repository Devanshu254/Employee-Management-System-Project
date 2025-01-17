package com.cts.ems.service.impl;

import org.springframework.stereotype.Service;

import com.cts.ems.dto.DepartmentDto;
import com.cts.ems.entity.Department;
import com.cts.ems.mapper.DepartmentMapper;
import com.cts.ems.repository.DepartmentRepository;
import com.cts.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;

	// Below method will implement the create department method
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}
	
}
