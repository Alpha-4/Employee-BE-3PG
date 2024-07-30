package com.ad.employee.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	 protected ResponseEntity<Object> handleCustomMethod(CustomException ex,
					HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	 }
		  
}
