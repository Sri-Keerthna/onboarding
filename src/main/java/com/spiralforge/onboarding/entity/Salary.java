package com.spiralforge.onboarding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequence")
	private Long salaryId;
	private Double salary;
	private String designation;
}
