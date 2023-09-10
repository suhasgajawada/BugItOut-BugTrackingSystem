package com.bts.exceptions;

@SuppressWarnings("serial")
public class ProjectNotFoundException extends Exception {

	public ProjectNotFoundException() {
		super();
	}

	public ProjectNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectNotFoundException(String message) {
		super(message);
	}

	public ProjectNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
