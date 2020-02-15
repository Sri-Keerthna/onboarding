package com.spiralforge.onboarding.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeListResponseDto {
	private List<EmployeeList> employeeList;
	private String message;
}
