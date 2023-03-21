package com.cab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = CabIdNotFoundException.class)
	public ResponseEntity<Object> userNotFoundExceptionHandler(CabIdNotFoundException ex) {
		return new ResponseEntity<Object>("CabId not found...", HttpStatus.NOT_FOUND);
	}

}
