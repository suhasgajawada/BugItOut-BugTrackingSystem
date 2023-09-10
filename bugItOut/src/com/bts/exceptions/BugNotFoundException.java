package com.bts.exceptions;

@SuppressWarnings("serial")
public class BugNotFoundException extends Exception {

	public BugNotFoundException() {
		super();
	}

	public BugNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BugNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BugNotFoundException(String message) {
		super(message);
	}

	public BugNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
