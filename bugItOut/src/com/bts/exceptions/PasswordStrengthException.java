package com.bts.exceptions;

@SuppressWarnings("serial")
public class PasswordStrengthException extends Exception {

	public PasswordStrengthException() {
		super();
	}

	public PasswordStrengthException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordStrengthException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordStrengthException(String message) {
		super(message);
	}

	public PasswordStrengthException(Throwable cause) {
		super(cause);
	}
	
}
