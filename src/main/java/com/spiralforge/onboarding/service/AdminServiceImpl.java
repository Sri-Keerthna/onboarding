package com.spiralforge.onboarding.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.onboarding.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	AdminRepository adminRepository;

}
