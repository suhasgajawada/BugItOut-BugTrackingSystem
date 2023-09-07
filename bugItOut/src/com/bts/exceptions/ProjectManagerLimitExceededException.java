package com.bts.exceptions;

@SuppressWarnings("serial")
public class ProjectManagerLimitExceededException extends Exception {

	public ProjectManagerLimitExceededException() {
		super();
	}

	public ProjectManagerLimitExceededException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProjectManagerLimitExceededException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectManagerLimitExceededException(String message) {
		super(message);
	}

	public ProjectManagerLimitExceededException(Throwable cause) {
		super(cause);
	}
	
}
