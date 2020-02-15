package com.spiralforge.onboarding.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.onboarding.controller.EmployeeController;
import com.spiralforge.onboarding.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeRepository employeeRepository;
}
