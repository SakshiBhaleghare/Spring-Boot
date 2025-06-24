package com.GlobalExceptionHandling;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(value = 1)
public class GlobalExceptionHandling {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> AllNullHandling() {

		return new ResponseEntity("Nullpointer occurs check you api's ", HttpStatus.OK);
	}

	@ExceptionHandler(FileNotAvailableCE.class)
	public ResponseEntity<?> fileRelatedException(Exception ex) {

		ex.printStackTrace();

		return new ResponseEntity(ex, HttpStatus.OK);
	}
}
