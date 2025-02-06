package ceu.dam.ad.mongo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.mongo.services.DatosIncorrectosException;

public class DatosIncorrectosExceptionHandler {

	@ExceptionHandler(DatosIncorrectosException.class)
	public ResponseEntity<String> handle(DatosIncorrectosException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
