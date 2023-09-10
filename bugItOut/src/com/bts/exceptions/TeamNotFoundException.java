package com.bts.exceptions;

@SuppressWarnings("serial")
public class TeamNotFoundException extends Exception {

	public TeamNotFoundException() {
		super();
	}

	public TeamNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TeamNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TeamNotFoundException(String message) {
		super(message);
	}

	public TeamNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
