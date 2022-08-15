package homebankingUserManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import validationsPackage.UsuarioDAOException;

public class UsuarioDAOCrudSQL {
	
	 public void crearTablaUsuarios() throws UsuarioDAOException {
		 String sql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, user VARCHAR(256), email VARCHAR(256), pass VARCHAR(10), dni INT(10), address VARCHAR(30))";
		 excecuteSqlQuery(sql);
	 }
	 
	 public void eliminarTablaUsuarios() throws UsuarioDAOException {
		 String sql = "DROP TABLE usuarios";
		 excecuteSqlQuery(sql);
	 }

	 public void crearUsuario(String user, String email, String pass, Integer dni, String address) throws UsuarioDAOException {
		 String sql = "INSERT INTO usuarios (user, email, pass, dni, address) VALUES ('" + user + "', '" + email + "', '" + pass + "', '" + dni + "', '" + address + "')";
		 excecuteSqlQuery(sql);
	 }
	 
	 public void borraUsuario(String username) throws UsuarioDAOException {
	        String sql = "DELETE FROM usuarios WHERE user = '" + username + "'";
	        excecuteSqlQuery(sql);
	 }
	 
	 public void actualizaUsuario(String user, String email, String pass, Integer dni, String address) throws UsuarioDAOException {
	        String sql = "UPDATE usuarios set email = '" + email + "', pass = '" + pass + "', dni = '" + dni + "', address = '" + address + "' WHERE user = '" + user + "'";
	        excecuteSqlQuery(sql);
	 }
	 
	 public List<Usuario> listaTodosLosUsuarios() throws UsuarioDAOException {
	        String sql = "SELECT * FROM usuarios";
	       return excecuteSqlGetData(sql);
	 }
	 
	 public Usuario muestraUsuario(String username) throws UsuarioDAOException {
	        String sql = "SELECT * FROM usuarios WHERE USER = '" + username +"'";
	        List<Usuario> list = excecuteSqlGetData(sql);
	        return list.get(0);
    }
	 
	 public void excecuteSqlQuery(String sql) throws UsuarioDAOException {
	        Connection c = DBManager.connect();
	        try {
	            Statement s = c.createStatement();
	            s.executeUpdate(sql);
	            c.commit();
	        } catch (SQLException e) {
	            try {
	                c.rollback();
	                e.printStackTrace();
	            } catch (SQLException e1) {
	                throw new UsuarioDAOException("Failed on excecute SQL query for User");
	            }
	        } finally {
	            try {
	                c.close();
	            } catch (SQLException e1) {
	                throw new UsuarioDAOException("Failed on excecute SQL query for User");
	            }
	        }
	    }
	 
	 
	 public List<Usuario> excecuteSqlGetData(String sql) throws UsuarioDAOException {
		 Connection c = DBManager.connect();
		 List<Usuario> resultado = new ArrayList<>();
	        try {
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);

	            
	            while (rs.next()) {
	            	int id = rs.getInt("id");
	                String nombreUsuario = rs.getString("user");
	                String mail = rs.getString("email");
	                String contrasenia = rs.getString("pass");
	                int docIdentidad = rs.getInt("dni");
	                String direccion = rs.getString("address");
	                Usuario u = new Usuario(nombreUsuario, mail, contrasenia, docIdentidad, direccion);
	                resultado.add(u);

	            }
	        } catch (SQLException e) {
	            try {
	                c.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        } finally {
	            try {
	                c.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	        return resultado;
	    }
}
