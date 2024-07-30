package com.ad.employee.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
    private String message;
    private HttpStatus httpStatus;
	
    public CustomException() {
		super();
	}
	
	public CustomException(String message) {
		super(message);
	}
	

	public CustomException(String errorCode, String message, HttpStatus httpStatus) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
    
    
}
