package validationsPackage;

public class ProductServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProductServiceException() {
    }

    public ProductServiceException(String s) {
        super(s);
    }

    public ProductServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ProductServiceException(Throwable throwable) {
        super(throwable);
    }
}
