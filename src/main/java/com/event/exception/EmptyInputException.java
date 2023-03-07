package com.event.exception;

import org.slf4j.Logger;

public class EmptyInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5091437363756753020L;
	private String errorcode;
	private String errorMessage;
	Logger logger = org.slf4j.LoggerFactory.getLogger(EmptyInputException.class);

	public EmptyInputException() {
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

	public EmptyInputException(String errorcode, String errorMessage) {
		super();
		logger.info("check for warning");
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}

}
