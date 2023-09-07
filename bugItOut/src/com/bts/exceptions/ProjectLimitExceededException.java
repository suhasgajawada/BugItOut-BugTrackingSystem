package com.bts.exceptions;

@SuppressWarnings("serial")
public class ProjectLimitExceededException extends Exception {

	public ProjectLimitExceededException() {
		super();
	}

	public ProjectLimitExceededException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProjectLimitExceededException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectLimitExceededException(String message) {
		super(message);
	}

	public ProjectLimitExceededException(Throwable cause) {
		super(cause);
	}
	
}
