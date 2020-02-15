package com.spiralforge.onboarding.dto;

import lombok.Data;

@Data
public class ErrorDto {
	private Integer statusCode;
	private String message;
}
