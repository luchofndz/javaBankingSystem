package homebankingUserManagementSystem;


import java.util.Date;

public class Usuario {
    private String user;
    private String email;
    private String pass;
    private Integer dni;
    private String address;

    public Usuario() {
    }

    public Usuario(String user, String email, String pass, Integer dni, String address) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.dni = dni;
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
    @Override
    public String toString() {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", dni='" + dni + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
