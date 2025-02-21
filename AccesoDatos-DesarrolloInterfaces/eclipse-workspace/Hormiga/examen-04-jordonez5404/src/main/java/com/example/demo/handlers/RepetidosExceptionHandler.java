package com.example.demo.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.RepetidosException;

@ControllerAdvice
public class RepetidosExceptionHandler {
	
	@ExceptionHandler(RepetidosException.class)
	public ResponseEntity<String> handle(RepetidosException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	

}
