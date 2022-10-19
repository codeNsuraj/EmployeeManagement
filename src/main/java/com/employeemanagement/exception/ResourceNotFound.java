package com.employeemanagement.exception;

@SuppressWarnings("serial")
public class ResourceNotFound extends RuntimeException {

	public ResourceNotFound(String message) {
		super(message);
	}
	
}
