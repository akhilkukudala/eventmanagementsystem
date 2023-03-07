package com.event.exception;

import org.slf4j.Logger;

public class PasswordIncorrectException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorcode;
	private String errorMessage;
	Logger logger = org.slf4j.LoggerFactory.getLogger(PasswordIncorrectException.class);

	public PasswordIncorrectException() {
		super();
	}

	public String getErrorcode() {
		return errorcode;

	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public PasswordIncorrectException(String errorcode, String errorMessage) {
		super();
		logger.warn("warning");
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}

}
