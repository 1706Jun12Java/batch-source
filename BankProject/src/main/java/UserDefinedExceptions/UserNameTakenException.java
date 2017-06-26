package UserDefinedExceptions;

public class UserNameTakenException extends RuntimeException {

	public UserNameTakenException() {
		super();
	}

	public UserNameTakenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNameTakenException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNameTakenException(String message) {
		super(message);
	}

	public UserNameTakenException(Throwable cause) {
		super(cause);
	}

}
