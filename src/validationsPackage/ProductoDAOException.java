package validationsPackage;

public class ProductoDAOException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoDAOException() {
    }

    public ProductoDAOException(String s) {
        super(s);
    }

    public ProductoDAOException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ProductoDAOException(Throwable throwable) {
        super(throwable);
    }
}