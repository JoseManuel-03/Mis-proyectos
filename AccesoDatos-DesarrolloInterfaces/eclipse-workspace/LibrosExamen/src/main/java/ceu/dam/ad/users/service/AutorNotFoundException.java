package ceu.dam.ad.users.service;

public class AutorNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8852185241666678442L;

	public AutorNotFoundException() {
	}

	public AutorNotFoundException(String message) {
		super(message);
	}

	public AutorNotFoundException(Throwable cause) {
		super(cause);
	}

	public AutorNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
