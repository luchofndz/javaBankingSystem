package bankingProducts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homebankingUserManagementSystem.Modal;
import homebankingUserManagementSystem.Usuario;
import homebankingUserManagementSystem.UsuarioDAOCrudSQL;
import validationsPackage.ProductoDAOException;
import validationsPackage.UsuarioDAOException;


public class ProductoDAOMethods implements ProductoDAO {
	
	public void crearTablaProductos() {
        try {
        	new ProductoDAOCrudSQL().crearTablaProductos();
		} catch (ProductoDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }
    
    public void eliminarTablaProductos() {
        try {
        	new ProductoDAOCrudSQL().eliminarTablaProductos();
		} catch (ProductoDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }

    public void crearProducto(Producto producto) {
        String user = producto.getUser();
        String cuentaTipo = producto.getCuentaTipo();
        Integer debito = producto.getDebito();
        Integer credito = producto.getCredito();
        Integer total = producto.getTotal();

        try {
			new ProductoDAOCrudSQL().crearProducto(user, cuentaTipo, debito, credito, total);
		} catch (ProductoDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }

	public void borraProducto(String user, String cuentaTipo) {
        try {
			new ProductoDAOCrudSQL().borraProducto(user, cuentaTipo);
		} catch (ProductoDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
	}

	public void actualizaProducto(Producto unUsuario) {
		// TODO Auto-generated method stub
		
	}

	public Producto muestraProducto(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Producto> listaTodosLosProductosDeUsuario() {
    	List<Producto> list = null;
        try {
        	list = new ProductoDAOCrudSQL().listaTodosLosProductos();
		} catch (ProductoDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
		return list;
	}
	
}
