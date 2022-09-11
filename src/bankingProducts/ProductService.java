package bankingProducts;

import java.util.List;

import homebankingUserManagementSystem.Modal;
import validationsPackage.ProductoDAOException;
import validationsPackage.ProductServiceException;
import bankingProducts.ProductoDAO;

public class ProductService {
	private ProductoDAO prodDao = new ProductoDAOMethods();
	
	public void crearTablaProductos() throws ProductServiceException {
        try {
        	new ProductoDAOCrudSQL(
        			).crearTablaProductos();
		} catch (ProductoDAOException e) {
			throw new ProductServiceException(e);
		}
    }
    
    public void eliminarTablaProductos() {
//        try {
//        	new ProductoDAOCrudSQL().eliminarTablaProductos();
//		} catch (ProductoDAOException e) {
//			new Modal().displayErrorModal(e.toString());
//		}
    }

    public void crearProducto(Producto producto) {
//        String user = producto.getUser();
//        String cuentaTipo = producto.getCuentaTipo();
//    	Integer numero = producto.getNumero();
//    	String alias = producto.getAlias();
//        Integer debito = producto.getDebito();
//        Integer credito = producto.getCredito();
//        Integer total = producto.getTotal();
//
//        try {
//			new ProductoDAOCrudSQL().crearProducto(user, cuentaTipo, numero, alias, debito, credito, total);
//		} catch (ProductoDAOException e) {
//			new Modal().displayErrorModal(e.toString());
//		}
    }

	public void borraProducto(String user, String cuentaTipo) {
//        try {
//			new ProductoDAOCrudSQL().borraProducto(user, cuentaTipo);
//		} catch (ProductoDAOException e) {
//			new Modal().displayErrorModal(e.toString());
//		}
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
//        try {
//        	list = new ProductoDAOCrudSQL().listaTodosLosProductos();
//		} catch (ProductoDAOException e) {
//			new Modal().displayErrorModal(e.toString());
//		}
   		return list;
	}
	
	public void transferFromTo(Producto userFrom, String userTo, Integer amount) {
//        try {
//			new ProductoDAOCrudSQL().transferFromTo(userFrom, userTo, amount);
//		} catch (ProductoDAOException e) {
//			new Modal().displayErrorModal(e.toString());
//		}
	}
}
