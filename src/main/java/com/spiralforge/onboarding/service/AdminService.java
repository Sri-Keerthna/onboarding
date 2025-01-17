package com.spiralforge.onboarding.service;

import java.util.List;

import javax.validation.Valid;

import com.spiralforge.onboarding.dto.EmployeeList;
import com.spiralforge.onboarding.dto.LoginRequestDto;
import com.spiralforge.onboarding.dto.LoginResponseDto;
import com.spiralforge.onboarding.exception.DetailsNotFoundException;
import com.spiralforge.onboarding.exception.EmployeeListException;

public interface AdminService {

	LoginResponseDto checkLogin(@Valid LoginRequestDto loginRequestDto) throws DetailsNotFoundException;

	List<EmployeeList> getEmployeeDetails() throws EmployeeListException;

	String updateEmployee(Long sapId);

}
