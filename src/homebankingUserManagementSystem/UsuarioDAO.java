package homebankingUserManagementSystem;

import java.util.List;

public interface UsuarioDAO {
	
	void crearTablaUsuarios();
	
	void eliminarTablaUsuarios();

	void crearUsuario(Usuario unUsuario);

	void borraUsuario(String username);

	void actualizaUsuario(Usuario unUsuario);

	Usuario muestraUsuario(String username);

	List<Usuario> listaTodosLosUsuarios();

}
