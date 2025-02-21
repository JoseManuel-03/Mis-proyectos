package com.example.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RepetidosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5267962279176857411L;

	public RepetidosException() {
	}

	public RepetidosException(String message) {
		super(message);
	}

	public RepetidosException(Throwable cause) {
		super(cause);
	}

	public RepetidosException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepetidosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
