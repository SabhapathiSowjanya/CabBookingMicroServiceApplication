package com.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException ex) {
		return new ResponseEntity<Object>("user not found...", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNameNotFoundException.class)
	public ResponseEntity<Object> userNameNotFoundExceptionHandler(UserNameNotFoundException ex) {
		return new ResponseEntity<Object>("user name not found...", HttpStatus.NOT_FOUND);
	}
	

}

