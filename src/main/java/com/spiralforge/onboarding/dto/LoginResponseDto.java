package com.spiralforge.onboarding.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
	private String message;
	private Long adminId;
	private String adminName;
	private Integer statusCode;
}
