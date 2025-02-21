package com.example.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7675445216103933601L;

	public NoExisteException() {
	}

	public NoExisteException(String message) {
		super(message);
	}

	public NoExisteException(Throwable cause) {
		super(cause);
	}

	public NoExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
