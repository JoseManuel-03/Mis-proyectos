package comerciales.services;

public class ComercialException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9009090828866451385L;

	public ComercialException() {
	}

	public ComercialException(String message) {
		super(message);
	}

	public ComercialException(Throwable cause) {
		super(cause);
	}

	public ComercialException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComercialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
