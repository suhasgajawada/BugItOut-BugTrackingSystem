package com.bts.exceptions;

@SuppressWarnings("serial")
public class TeamAssignmentException extends Exception {

	public TeamAssignmentException() {
		super();
	}

	public TeamAssignmentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TeamAssignmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public TeamAssignmentException(String message) {
		super(message);
	}

	public TeamAssignmentException(Throwable cause) {
		super(cause);
	}
	
}
