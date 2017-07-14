package CustomExceptions;

public class UserNameTakenException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNameTakenException() {
	}

	public UserNameTakenException(String message) {
		super(message);
	}

	public UserNameTakenException(Throwable cause) {
		super(cause);
	}

	public UserNameTakenException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNameTakenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
