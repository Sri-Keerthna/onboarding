package com.spiralforge.onboarding.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.spiralforge.onboarding.constants.ApiConstant;
import com.spiralforge.onboarding.constants.ApplicationConstants;
import com.spiralforge.onboarding.dto.EmployeeList;
import com.spiralforge.onboarding.dto.LoginRequestDto;
import com.spiralforge.onboarding.dto.LoginResponseDto;
import com.spiralforge.onboarding.dto.UserDto;
import com.spiralforge.onboarding.entity.Admin;
import com.spiralforge.onboarding.entity.Employee;
import com.spiralforge.onboarding.exception.AdminNotFoundException;
import com.spiralforge.onboarding.exception.EmployeeListException;
import com.spiralforge.onboarding.repository.AdminRepository;
import com.spiralforge.onboarding.repository.EmployeeRepository;
import com.spiralforge.onboarding.repository.SalaryRepository;

@Service
public class AdminServiceImpl implements AdminService {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;


	@Autowired
	private JmsTemplate jmsTemplate;

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
	@Override
	public LoginResponseDto checkLogin(@Valid LoginRequestDto loginRequestDto) throws AdminNotFoundException {
		logger.info("For checking whether the credentials are valid or not");
		Admin admin = adminRepository.findByMobileNumberAndPassword(loginRequestDto.getMobileNumber(),
				loginRequestDto.getPassword());
		if (Objects.isNull(admin)) {
			logger.error(ApiConstant.ADMIN_NOTFOUND_MESSAGE);
			throw new AdminNotFoundException(ApiConstant.ADMIN_NOTFOUND_MESSAGE);
		}
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		BeanUtils.copyProperties(admin, loginResponseDto);
		logger.info("Admin details are being set as a response");
		return loginResponseDto;
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
	@Override
	public List<EmployeeList> getEmployeeDetails() throws EmployeeListException {
		List<Employee> employee = employeeRepository.findAllByEmployeeStatus(ApplicationConstants.PENDING_STATUS);
		if (employee.isEmpty()) {
			logger.error(ApiConstant.LIST_EMPTY_MESSAGE);
			throw new EmployeeListException(ApiConstant.LIST_EMPTY_MESSAGE);
		}
		List<EmployeeList> employeeList = new ArrayList<>();
		employee.forEach(employeeDetails -> {
			EmployeeList employeeListDetails = new EmployeeList();
			BeanUtils.copyProperties(employeeDetails, employeeListDetails);
			employeeList.add(employeeListDetails);
		});
		return employeeList;
	}

	/**
	 * @author Muthu
	 * 
	 *         Method is used to update the status of a particular employee
	 * 
	 * @param sapId Id by which the employee is identified
	 * @return success/failure message
	 */
	@Override
	public String updateEmployee(Long sapId) {
		Optional<Employee> employee = employeeRepository.findById(sapId);
		if (!(employee.isPresent())) {
			return ApiConstant.EMPLOYEE_NOTFOUND_MESSAGE;
		}
		employee.get().setEmployeeStatus(ApplicationConstants.SUCCESS_STATUS);
		employeeRepository.save(employee.get());
		publishNewEmployee(employee);
		return ApiConstant.UPDATED_MESSAGE;
	}


	/**
	 * @author Sujal
	 * 
	 *         Method is used to publish a particular employee onboarded
	 * 
	 * @param Optional<Employee> the employee data
=	 */
	public void publishNewEmployee(Optional<Employee> employee) {

		logger.info("publishing the message");
		if (employee.isPresent()) {
			UserDto userDto = new UserDto();
			userDto.setSapId(employee.get().getSapId());
			userDto.setFullName(employee.get().getFirstName() +" "+ employee.get().getLastName());
			userDto.setSalary(employee.get().getSalary().getSalary());
			jmsTemplate.convertAndSend(ApplicationConstants.EMPLOYEE_ONBOARDED, userDto);

		}
	}
}
