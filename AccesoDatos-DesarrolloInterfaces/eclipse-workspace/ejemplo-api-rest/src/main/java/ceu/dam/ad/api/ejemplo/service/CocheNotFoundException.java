package ceu.dam.ad.api.ejemplo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CocheNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1814866497641539869L;

	public CocheNotFoundException() {
		super();
	}

	public CocheNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CocheNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CocheNotFoundException(String message) {
		super(message);
	}

	public CocheNotFoundException(Throwable cause) {
		super(cause);
	}

	
	
}
