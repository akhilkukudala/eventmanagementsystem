package com.event.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	Logger logger = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(EmptyInputException.class) // user generated
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException) {
		logger.warn("warning");
		return new ResponseEntity<String>("Input field is empty,plz look at it", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleEmptyInputException(NoSuchElementException elementexception) {
		logger.warn("warning");
		return new ResponseEntity<String>("Requested product doesn't exist", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PasswordIncorrectException.class)
	public ResponseEntity<String> handlePasswordIncorrectException(
			PasswordIncorrectException passwordincorrectexception) {
		logger.warn("warning");
		return new ResponseEntity<String>(
				"Password does not match with confirm password\nPlease enter the same password in both the fields",
				HttpStatus.BAD_REQUEST);
	}

}
