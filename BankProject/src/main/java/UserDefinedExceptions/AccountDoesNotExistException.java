package UserDefinedExceptions;

public class AccountDoesNotExistException extends RuntimeException {

	public AccountDoesNotExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountDoesNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountDoesNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
