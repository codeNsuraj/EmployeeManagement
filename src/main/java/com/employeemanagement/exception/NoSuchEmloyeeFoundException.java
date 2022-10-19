package com.employeemanagement.exception;

@SuppressWarnings("serial")
public class NoSuchEmloyeeFoundException extends RuntimeException {

	public NoSuchEmloyeeFoundException(String message) {
		super(message);
	}
}
