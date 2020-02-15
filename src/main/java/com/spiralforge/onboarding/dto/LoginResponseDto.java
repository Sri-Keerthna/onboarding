package com.spiralforge.onboarding.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
	private String message;
	private Long sapId;
	private String name;
	private String role;
	private Integer statusCode;
}
