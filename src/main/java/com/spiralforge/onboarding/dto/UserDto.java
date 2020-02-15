package com.spiralforge.onboarding.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long sapId;
	private String fullName;
	private Double salary;
	
}
