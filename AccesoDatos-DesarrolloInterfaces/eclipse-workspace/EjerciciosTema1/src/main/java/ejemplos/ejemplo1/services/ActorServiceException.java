package ejemplos.ejemplo1.services;

public class ActorServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1617187209099891914L;

	public ActorServiceException() {
	}

	public ActorServiceException(String message) {
		super(message);
	}

	public ActorServiceException(Throwable cause) {
		super(cause);
	}

	public ActorServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActorServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
