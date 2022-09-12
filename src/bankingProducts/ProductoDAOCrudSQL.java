package bankingProducts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homebankingUserManagementSystem.DBManager;
import homebankingUserManagementSystem.Usuario;
import validationsPackage.ProductoDAOException;
import validationsPackage.UsuarioDAOException;

public class ProductoDAOCrudSQL {
	
	 public void crearTablaProductos() throws ProductoDAOException {
		 String sql = "CREATE TABLE productos ( id INTEGER IDENTITY, user VARCHAR(30), cuentaTipo VARCHAR(256), numero INT(256), alias VARCHAR(35), debito INT(256), credito INT(10), total INT(10))";
		 excecuteSqlQuery(sql);
	 }
	 
	 public void eliminarTablaProductos() throws ProductoDAOException {
		 String sql = "DROP TABLE productos";
		 excecuteSqlQuery(sql);
	 }

	 public void crearProducto(String user, String cuentaTipo, Integer numero, String alias, Integer debito, Integer credito, Integer total) throws ProductoDAOException {
		 String sql = "INSERT INTO productos (user, cuentaTipo, numero, alias, debito, credito, total) VALUES ('" + user + "', '" + cuentaTipo + "', '" + numero + "', '" + alias + "', '" + debito + "', '" + credito + "', '" + total + "')";
		 excecuteSqlQuery(sql);
	 } 

	 public void borraProducto(String user, String cuentaTipo) throws ProductoDAOException {
	        String sql = "DELETE FROM productos WHERE cuentaTipo = '" + cuentaTipo + "' AND user = '" + user + "'";
	        excecuteSqlQuery(sql);
	 }
	 
	 // TODO: update parameters and sql with new params
	 public void actualizaUsuario(String user, String email, String cuentaTipo, Integer debito, Integer credito, Integer total) throws ProductoDAOException {
	        String sql = "UPDATE productos set email = '" + email + "', cuentaTipo = '" + cuentaTipo + "', debito = '" + debito + "', credito = '" + credito + "', total = '" + total + "' WHERE user = '" + user + "'";
	        excecuteSqlQuery(sql);
	 }
	 
	 public void transferFromTo(Producto userFrom, String userTo, Integer amount) throws ProductoDAOException {
		 // sql get user data, modify user from ad user to
		 
		 
	        String sql = "UPDATE productos set debito = '" + (userFrom.getDebito() + amount) + "', total = total - '" + amount + "' WHERE numero = '" + userFrom.getNumero() + "'";
	        excecuteSqlQuery(sql);
	        
	        boolean isNumeric = userTo.chars().allMatch( Character::isDigit );
	        
	        String sqlUserTo = "UPDATE productos set credito = credito + '" + amount + "', total = total + '" + amount + "' WHERE ";
	        if(isNumeric) {
	        	sqlUserTo += "numero = '" + userTo + "'";
	        } else {
	        	sqlUserTo +=  "alias = '" + userTo  + "' OR user = '" + userTo + "'";
	        }
	        System.out.println(sql);
	        System.out.println(sqlUserTo);
	        excecuteSqlQuery(sqlUserTo);
	 }

	 private String parseInt(String userTo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excecuteSqlQuery(String sql) throws ProductoDAOException {
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
	                throw new ProductoDAOException("Failed on excecute SQL query for Product");
	            }
	        } finally {
	            try {
	                c.close();
	            } catch (SQLException e1) {
	                throw new ProductoDAOException("Failed on excecute SQL query for Product");
            }
        }
	 }
	 
	 public List<Producto> listaTodosLosProductos() throws ProductoDAOException {
	        String sql = "SELECT * FROM productos";
	       return excecuteSqlGetData(sql);
	 }
	 
	 public List<Producto> excecuteSqlGetData(String sql) throws ProductoDAOException {
		 Connection c = DBManager.connect();
		 List<Producto> resultado = new ArrayList<>();
	        try {
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);

	            
	            while (rs.next()) {
	            	int id = rs.getInt("id");
	                String nombreUsuario = rs.getString("user");
	                String cuentaTipo = rs.getString("cuentaTipo");
	                int numero = rs.getInt("numero");
	                String alias = rs.getString("alias");
	                int debito = rs.getInt("debito");
	                int credito = rs.getInt("credito");
	                int total = rs.getInt("total");
	                Producto producto = new Producto(id, nombreUsuario, cuentaTipo, numero, alias, debito, credito, total);
	                resultado.add(producto);

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
