package com.bts.exceptions;

@SuppressWarnings("serial")
public class InvalidDateException extends Exception {

	public InvalidDateException() {
		super();
	}

	public InvalidDateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidDateException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDateException(String message) {
		super(message);
	}

	public InvalidDateException(Throwable cause) {
		super(cause);
	}
	
}
