package validationsPackage;

public class NumberRequiredException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberRequiredException() {
    }

    public NumberRequiredException(String s) {
        super(s);
    }

    public NumberRequiredException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NumberRequiredException(Throwable throwable) {
        super(throwable);
    }
}