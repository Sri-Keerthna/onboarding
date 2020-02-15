package com.spiralforge.onboarding.constants;

/**
 * 
 * @author Sujal
 *
 */
public class ApiConstant {

	private ApiConstant() {
	}

	public static final String ADMIN_NOTFOUND_MESSAGE = "Invalid credentials. Please enter valid username and password";
	public static final String LOGIN_SUCCESS = "You are successfully logged in";

	public static final String INTERNAL_SERVER_ERROR = "INTERNAL SERVER ERROR";
	public static final String VALIDATION_FAILED = "VALIDATION FAILED";
	public static final String NO_ELEMENT_FOUND = "NO ELEMENT FOUND";
	public static final String USER_NOT_FOUND = "Not a valid user";

	public static final Integer SUCCESS_CODE = 200;
	public static final Integer FAILURE_CODE = 404;
	public static final Integer NO_CONTENT_CODE = 204;

	public static final Float PERCENTAGE_DIVIDE_VALUE = 100.0f;
	public static final String REGISTERED_SUCCESS = "Registered Successfully";
	public static final String EMPLOYEE_NOTFOUND_MESSAGE = "No employee found";
	public static final String UPDATED_MESSAGE = "Successfully updated";
	public static final String DETAILS_NOT_FOUND="Please check the details entered";
	public static final String LIST_SUCCESS_MESSAGE = "The list of employees with status pending is displayed";
	public static final String LIST_EMPTY_MESSAGE = "There are no employees currently with status pending";
	public static final String EMPTY_CUSTOMERINPUT_MESSAGE = "Field can't be left blank";
	public static final String ALREADY_UPDATED_MESSAGE = "Detail is already updated";

}
