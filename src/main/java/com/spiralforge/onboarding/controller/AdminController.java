package com.spiralforge.onboarding.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiralforge.onboarding.constants.ApiConstant;
import com.spiralforge.onboarding.dto.EmployeeList;
import com.spiralforge.onboarding.dto.EmployeeListResponseDto;
import com.spiralforge.onboarding.dto.LoginRequestDto;
import com.spiralforge.onboarding.dto.LoginResponseDto;
import com.spiralforge.onboarding.exception.AdminNotFoundException;
import com.spiralforge.onboarding.exception.EmployeeListException;
import com.spiralforge.onboarding.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AdminController {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	AdminService adminService;

	/**
	 * @author Muthu
	 * 
	 *         Method is used for login for the admin
	 * 
	 * @param loginRequestDto which takes the mobile number and password as
	 *                        parameters
	 * @return LoginResponseDto which has name,id,message and status code as a
	 *         response
	 * @throws AdminNotFoundException is called when the entered credentials is
	 *                                invalid
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> checkLogin(@Valid @RequestBody LoginRequestDto loginRequestDto)
			throws AdminNotFoundException {
		logger.info("For checking whether the person is staff or a customer");
		LoginResponseDto loginResponse = adminService.checkLogin(loginRequestDto);
		logger.info(ApiConstant.LOGIN_SUCCESS);
		loginResponse.setStatusCode(ApiConstant.SUCCESS_CODE);
		loginResponse.setMessage(ApiConstant.LOGIN_SUCCESS);
		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}

	/**
	 * @author Muthu
	 * 
	 *         Method is used to get the list of employee with their status pending
	 * 
	 * @return EmployeeListResponseDto which has the employee list that includes
	 *         their sapId,designation,name and date of joining
	 * 
	 * @throws EmployeeListException is called when the list is empty
	 */
	@GetMapping
	public ResponseEntity<EmployeeListResponseDto> getEmployeeDetails() throws EmployeeListException {
		List<EmployeeList> employeeList = adminService.getEmployeeDetails();
		EmployeeListResponseDto employeeListResponseDto = new EmployeeListResponseDto();
		if (employeeList.isEmpty()) {
			employeeListResponseDto.setMessage(ApiConstant.LIST_EMPTY_MESSAGE);
			return new ResponseEntity<>(employeeListResponseDto, HttpStatus.NOT_FOUND);
		}
		logger.info(ApiConstant.LIST_SUCCESS_MESSAGE);
		employeeListResponseDto.setEmployeeList(employeeList);
		employeeListResponseDto.setMessage(ApiConstant.LIST_SUCCESS_MESSAGE);
		return new ResponseEntity<>(employeeListResponseDto, HttpStatus.OK);
	}

	/**
	 * @author Muthu
	 * 
	 *         Method is used to update the status of a particular employee
	 * 
	 * @param sapId Id by which the employee is identified
	 * @return success/failure message
	 */
	@PutMapping("/{sapId}")
	public ResponseEntity<String> updateEmployee(@PathVariable(value = "sapId") Long sapId) {
		String response = adminService.updateEmployee(sapId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
