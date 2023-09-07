package com.bts.exceptions;

@SuppressWarnings("serial")
public class BugStatusTransitionException extends Exception {

	public BugStatusTransitionException() {
		super();
	}

	public BugStatusTransitionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BugStatusTransitionException(String message, Throwable cause) {
		super(message, cause);
	}

	public BugStatusTransitionException(String message) {
		super(message);
	}

	public BugStatusTransitionException(Throwable cause) {
		super(cause);
	}
	
}
