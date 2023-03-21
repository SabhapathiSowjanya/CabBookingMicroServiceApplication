package com.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {	
	
	@ExceptionHandler(value = AdminIdNotFoundException.class)
	public ResponseEntity<Object> userNotFoundExceptionHandler(AdminIdNotFoundException ex) {
		return new ResponseEntity<Object>("Admin not found...", HttpStatus.NOT_FOUND);
	}
	

		
}