package validationsPackage;

public class TextLengthOutOfBoundsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextLengthOutOfBoundsException() {
    }

    public TextLengthOutOfBoundsException(String s) {
        super(s);
    }

    public TextLengthOutOfBoundsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TextLengthOutOfBoundsException(Throwable throwable) {
        super(throwable);
    }
}