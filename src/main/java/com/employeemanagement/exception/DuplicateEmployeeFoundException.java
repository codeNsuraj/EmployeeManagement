package com.employeemanagement.exception;

@SuppressWarnings("serial")
public class DuplicateEmployeeFoundException extends RuntimeException {

	public DuplicateEmployeeFoundException(String message) {
		super(message);
	}
}
