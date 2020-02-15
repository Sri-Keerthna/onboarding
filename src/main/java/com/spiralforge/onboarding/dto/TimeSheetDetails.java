package com.spiralforge.onboarding.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TimeSheetDetails {
	private LocalDate date;
	private DayOfWeek day;
}
