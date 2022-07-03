package validationsPackage;

public class InvalidPasswordException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException() {
    }

    public InvalidPasswordException(String s) {
        super(s);
    }

    public InvalidPasswordException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidPasswordException(Throwable throwable) {
        super(throwable);
    }
}