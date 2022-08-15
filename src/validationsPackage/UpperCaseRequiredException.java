package validationsPackage;

public class UpperCaseRequiredException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpperCaseRequiredException() {
    }

    public UpperCaseRequiredException(String s) {
        super(s);
    }

    public UpperCaseRequiredException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UpperCaseRequiredException(Throwable throwable) {
        super(throwable);
    }
}