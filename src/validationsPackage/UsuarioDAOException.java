package validationsPackage;

public class UsuarioDAOException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioDAOException() {
    }

    public UsuarioDAOException(String s) {
        super(s);
    }

    public UsuarioDAOException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UsuarioDAOException(Throwable throwable) {
        super(throwable);
    }
}