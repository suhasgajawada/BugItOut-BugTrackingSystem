package com.bts.exceptions;

@SuppressWarnings("serial")
public class BugAssignmentException extends Exception {

	public BugAssignmentException() {
		super();
	}

	public BugAssignmentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BugAssignmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public BugAssignmentException(String message) {
		super(message);
	}

	public BugAssignmentException(Throwable cause) {
		super(cause);
	}
	
}
