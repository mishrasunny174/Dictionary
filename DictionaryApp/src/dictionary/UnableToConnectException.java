package dictionary;

public class UnableToConnectException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnableToConnectException(String errorMsg) {
		super(errorMsg);
	}
}
