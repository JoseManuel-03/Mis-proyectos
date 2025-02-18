package ceu.dam.javafx.practica3.service;

public class AnimalDataNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7754588375958363342L;

	public AnimalDataNotValidException() {
	}

	public AnimalDataNotValidException(String message) {
		super(message);
	}

	public AnimalDataNotValidException(Throwable cause) {
		super(cause);
	}

	public AnimalDataNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnimalDataNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
