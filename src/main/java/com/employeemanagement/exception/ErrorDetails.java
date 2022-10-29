package com.employeemanagement.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime  eventTimeStamp;
	private String message;
	private String details;
	private String errorCode;
	public LocalDateTime  getEventTimeStamp() {
		return eventTimeStamp;
	}
	public void setEventTimeStamp(LocalDateTime  eventTimeStamp) {
		this.eventTimeStamp = eventTimeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public ErrorDetails(LocalDateTime  eventTimeStamp, String message, String details, String errorCode) {
		super();
		this.eventTimeStamp = eventTimeStamp;
		this.message = message;
		this.details = details;
		this.errorCode = errorCode;
	}
}
