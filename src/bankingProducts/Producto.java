package bankingProducts;

public class Producto {
    private String user;
    private String cuentaTipo;
    private Integer debito;
    private Integer credito;
    private Integer total;
    private Integer id;
    private Integer numero;
    private String alias;

    public Producto(
    		Integer id,
    		String user, 
    		String cuentaTipo,
    		Integer numero,
    		String alias,
    		Integer debito, 
    		Integer credito, 
    		Integer total
    ) {
        this.setId(id);
        this.setUser(user);
        this.setCuentaTipo(cuentaTipo);
        this.setDebito(debito);
        this.setCredito(credito);
        this.setTotal(total);
        this.setNumero(numero);
        this.setAlias(alias);
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
}
