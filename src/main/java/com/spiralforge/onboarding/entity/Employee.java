package com.spiralforge.onboarding.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	private String designation;
	private String employeeBand;
	private LocalDate dateOfJoining;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "salary_id")
	private Salary salary;
}
