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
        	new ProductoDAOCrudSQL().crearTablaProductos();
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

    public void crearProducto(Producto producto) throws ProductServiceException {
        try {
			prodDao.crearProducto(producto);
		} catch (Exception e) {
			throw new ProductServiceException(e);
		}
    }

	public void borraProducto(String user, String cuentaTipo) throws ProductServiceException {
        try {
        	prodDao.borraProducto(user, cuentaTipo);
		} catch (Exception e) {
			throw new ProductServiceException(e);
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
//        try {
//        	list = new ProductoDAOCrudSQL().listaTodosLosProductos();
//		} catch (ProductoDAOException e) {
//			new Modal().displayErrorModal(e.toString());
//		}
   		return list;
	}
	
	public void transferFromTo(Producto userFrom, String userTo, Integer amount) throws ProductServiceException {
        try {
			new ProductoDAOCrudSQL().transferFromTo(userFrom, userTo, amount);
		} catch (ProductoDAOException e) {
			throw new ProductServiceException(e);
		}
	}
}
