package com.spiralforge.onboarding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "employeeSequence", initialValue = 100001, allocationSize = 1)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequence")
	private Long sapId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Long mobileNumber;
	private String employeeStatus;
}
