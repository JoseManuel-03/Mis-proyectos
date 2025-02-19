package ceu.dam.ad.users.service;

public class AutorServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948386454178724983L;

	public AutorServiceException() {
	}

	public AutorServiceException(String message) {
		super(message);
	}

	public AutorServiceException(Throwable cause) {
		super(cause);
	}

	public AutorServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutorServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
