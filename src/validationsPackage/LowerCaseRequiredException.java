package validationsPackage;

public class LowerCaseRequiredException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LowerCaseRequiredException() {
    }

    public LowerCaseRequiredException(String s) {
        super(s);
    }

    public LowerCaseRequiredException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public LowerCaseRequiredException(Throwable throwable) {
        super(throwable);
    }
}