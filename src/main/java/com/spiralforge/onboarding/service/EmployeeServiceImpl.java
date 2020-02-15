package com.spiralforge.onboarding.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.onboarding.constants.ApiConstant;
import com.spiralforge.onboarding.constants.ApplicationConstants;
import com.spiralforge.onboarding.controller.EmployeeController;
import com.spiralforge.onboarding.dto.EmployeeRequestDto;
import com.spiralforge.onboarding.dto.EmployeeResponseDto;
import com.spiralforge.onboarding.dto.TimeSheetDetails;
import com.spiralforge.onboarding.dto.TimeSheetResponseDto;
import com.spiralforge.onboarding.entity.Employee;
import com.spiralforge.onboarding.entity.Salary;
import com.spiralforge.onboarding.exception.DesignationNotFoundException;
import com.spiralforge.onboarding.repository.EmployeeRepository;
import com.spiralforge.onboarding.repository.SalaryRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SalaryRepository salaryRepository;

	@Override
	public EmployeeResponseDto addEmployee(@Valid EmployeeRequestDto employeeRequestDto)
			throws DesignationNotFoundException {
		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		Optional<Salary> salary = salaryRepository.findByDesignation(employeeRequestDto.getDesignation());
		if (!salary.isPresent()) {
			throw new DesignationNotFoundException(ApplicationConstants.DESIGNATION_NOT_FOUND_EXCEPTION);
		}
		Employee employee = new Employee();
		employee.setDateOfJoining(LocalDate.now());
		employee.setEmployeeStatus(ApplicationConstants.PENDING_STATUS);
		employee.setSalary(salary.get());
		BeanUtils.copyProperties(employeeRequestDto, employee);
		employeeRepository.save(employee);
		employeeResponseDto.setMessage(ApiConstant.REGISTERED_SUCCESS);
		employeeResponseDto.setStatusCode(ApiConstant.SUCCESS_CODE);
		return employeeResponseDto;
	}

	@Override
	public TimeSheetResponseDto timesheetEmployee() {
		TimeSheetResponseDto timeSheetResponseDto = new TimeSheetResponseDto();
		List<TimeSheetDetails> timeSheet = new ArrayList<>();

		for (LocalDate currentDate = LocalDate.now(); currentDate.isBefore(currentDate.plusDays(7)); currentDate
				.plusDays(1)) {
			TimeSheetDetails timeSheetDetails = new TimeSheetDetails();
			timeSheetDetails.setDate(currentDate);
			timeSheetDetails.setDay(currentDate.getDayOfWeek());
			timeSheet.add(timeSheetDetails);
		}
		timeSheetResponseDto.setTimesheetDetails(timeSheet);
		return timeSheetResponseDto;
	}

}
