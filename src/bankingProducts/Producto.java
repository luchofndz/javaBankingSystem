package bankingProducts;

public class Producto {
    private String user;
    private String cuentaTipo;
    private Integer debito;
    private Integer credito;
    private Integer total;

    public Producto(String user, String cuentaTipo, Integer debito, Integer credito, Integer total) {
        this.setUser(user);
        this.setCuentaTipo(cuentaTipo);
        this.setDebito(debito);
        this.setCredito(credito);
        this.setTotal(total);
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCuentaTipo() {
		return cuentaTipo;
	}

	public void setCuentaTipo(String cuentaTipo) {
		this.cuentaTipo = cuentaTipo;
	}

	public Integer getDebito() {
		return debito;
	}

	public void setDebito(Integer debito) {
		this.debito = debito;
	}

	public Integer getCredito() {
		return credito;
	}

	public void setCredito(Integer credito) {
		this.credito = credito;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
