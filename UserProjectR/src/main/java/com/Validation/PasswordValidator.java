package com.Validation;

public class PasswordValidator {

	private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?]).{8,16}$";

	public static boolean isValid(String password) {
		return password.matches(PASSWORD_PATTERN);
	}
}
