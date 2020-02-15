package com.spiralforge.onboarding.entity;

import java.time.LocalDate;

import javax.persistence.Id;

public class Timesheet {

	@Id
	private Long timeSheetId;
	private LocalDate date;
	private Integer hour;
}
