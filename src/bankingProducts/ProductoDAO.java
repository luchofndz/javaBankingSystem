package bankingProducts;

import java.util.List;

public interface ProductoDAO {

	void crearTablaProductos();
	
	void eliminarTablaProductos();

	void crearProducto(Producto product);

	void borraProducto(String user, String cuentaTipo);

	void actualizaProducto(Producto unUsuario);

	Producto muestraProducto(String username);

	List<Producto> listaTodosLosProductosDeUsuario();
}
