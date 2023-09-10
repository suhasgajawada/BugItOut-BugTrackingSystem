package com.bts.exceptions;

@SuppressWarnings("serial")
public class FileImportException extends Exception {

	public FileImportException() {
		super();
	}

	public FileImportException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileImportException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileImportException(String message) {
		super(message);
	}

	public FileImportException(Throwable cause) {
		super(cause);
	}
	
}
