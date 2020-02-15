package com.spiralforge.onboarding.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {

	@Size(min = 2, max = 20, message = "Enter a valid first name")
	private String firstName;
	@Size(min = 2, max = 20, message = "Enter a valid last name")
	private String lastName;
	@Email(message = "Enter a valid email Id")
	private String emailId;
	private Long mobileNumber;
	@Size(min = 2, max = 20, message = "Enter a valid designation")
	private String designation;
	@Size(min = 2, max = 20, message = "Enter a valid employee band")
	private String employeeBand;
	private String password;
}
