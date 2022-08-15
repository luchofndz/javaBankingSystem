package validationsPackage;

public class StringClassExeption extends Exception {

	private static final long serialVersionUID = 1L;

	public StringClassExeption() {
    }

    public StringClassExeption(String s) {
        super(s);
    }

    public StringClassExeption(String s, Throwable throwable) {
        super(s, throwable);
    }

    public StringClassExeption(Throwable throwable) {
        super(throwable);
    }
}
