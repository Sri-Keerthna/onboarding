package com.spiralforge.onboarding.service;

import javax.validation.Valid;

import com.spiralforge.onboarding.dto.EmployeeRequestDto;
import com.spiralforge.onboarding.dto.EmployeeResponseDto;
import com.spiralforge.onboarding.exception.DesignationNotFoundException;

public interface EmployeeService {

	EmployeeResponseDto addEmployee(@Valid EmployeeRequestDto employeeRequestDto) throws DesignationNotFoundException;

}
