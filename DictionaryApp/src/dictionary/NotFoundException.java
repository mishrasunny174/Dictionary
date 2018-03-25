package dictionary;

public class NotFoundException extends Exception {
	private static final long serialVersionUID = 2L;

	public NotFoundException(String title) {
		super(title);
	}
}
