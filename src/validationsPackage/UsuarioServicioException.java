package validationsPackage;

public class UsuarioServicioException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioServicioException() {
    }

    public UsuarioServicioException(String s) {
        super(s);
    }

    public UsuarioServicioException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UsuarioServicioException(Throwable throwable) {
        super(throwable);
    }
}
