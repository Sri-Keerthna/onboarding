package com.spiralforge.onboarding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}