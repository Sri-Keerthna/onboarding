package com.spiralforge.onboarding.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiralforge.onboarding.dto.EmployeeRequestDto;
import com.spiralforge.onboarding.dto.EmployeeResponseDto;
import com.spiralforge.onboarding.exception.DesignationNotFoundException;
import com.spiralforge.onboarding.service.EmployeeService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/employees")
public class EmployeeController {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeResponseDto> addEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto)
			throws DesignationNotFoundException {
		EmployeeResponseDto employeeResponseDto = employeeService.addEmployee(employeeRequestDto);
		return new ResponseEntity<>(employeeResponseDto, HttpStatus.OK);
	}
}
