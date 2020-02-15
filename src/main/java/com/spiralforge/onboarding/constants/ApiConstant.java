package com.spiralforge.onboarding.constants;

/**
 * 
 * @author Sujal
 *
 */
public class ApiConstant {

	private ApiConstant() {	}

	public static final String ADMIN_NOTFOUND_MESSAGE = "Invalid credentials. Please enter valid username and password";
	public static final String LOGIN_SUCCESS = "You are successfully logged in";

	public static final String SCHEMELIST_EMPTY_MESSAGE = "There are currently no statistics found";
	public static final String SCHEMELIST_MESSAGE = "The statistics for the schemes are displayed";

	public static final String SUCCESS = "Operation successful";
	public static final String FAILED = "Operation faild";

	public static final String INTERNAL_SERVER_ERROR = "INTERNAL SERVER ERROR";
	public static final String VALIDATION_FAILED = "VALIDATION FAILED";
	public static final String NO_ELEMENT_FOUND = "NO ELEMENT FOUND";
	public static final String USER_NOT_FOUND = "Not a valid user";

	public static final Integer SUCCESS_CODE = 200;
	public static final Integer FAILURE_CODE = 404;
	public static final Integer NO_CONTENT_CODE = 204;

	public static final Float PERCENTAGE_DIVIDE_VALUE = 100.0f;
}
