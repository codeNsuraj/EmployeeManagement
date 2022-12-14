package com.employeemanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHanling {

	@ExceptionHandler(value = {ResourceNotFound.class})
	public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFound resourceNotFound, WebRequest request) {

		return new ResponseEntity<ErrorDetails>(new ErrorDetails(new Date(), resourceNotFound.getMessage(),
				request.getDescription(false), ErrorCode.ER101.toString()), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(DuplicateEmployeeFoundException.class)
	public ResponseEntity<ErrorDetails> handleDuplicateEmployeeFoundException(
			DuplicateEmployeeFoundException duplicateEmployeeFoundException, WebRequest request) {

		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(new Date(), duplicateEmployeeFoundException.getMessage(),
						request.getDescription(false), ErrorCode.ER201.toString()),
				HttpStatus.CONFLICT);

	}

	@ExceptionHandler(NoSuchEmloyeeFoundException.class)
	public ResponseEntity<ErrorDetails> handleNoSuchEmloyeeFoundException(
			NoSuchEmloyeeFoundException duplicateEmployeeFoundException, WebRequest request) {

		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(new Date(), duplicateEmployeeFoundException.getMessage(),
						request.getDescription(false), ErrorCode.ER301.toString()),
				HttpStatus.NOT_FOUND);

	}

}
