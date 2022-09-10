package homebankingUserManagementSystem;

import java.util.List;

import validationsPackage.UsuarioDAOException;
import validationsPackage.UsuarioServicioException;

public class UserService {
	private UsuarioDAO dao = new UsuarioDAOH2Impl();

	public void crearTablaUsuarios() {

    }
    
    public void eliminarTablaUsuarios() {
   
    }

    public void crearUsuario(Usuario unUsuario) {
       
    }

    public void borraUsuario(String username) {
       
    }

    public void actualizaUsuario(Usuario unUsuario) {
        
    }
    
    public List<Usuario> listaTodosLosUsuarios() throws UsuarioServicioException {
    	List<Usuario> lista = null;
        try {
        	lista = dao.listaTodosLosUsuarios();
        	System.out.println(lista);
        	return lista;
		} catch (Exception e) {
			throw new UsuarioServicioException(e);
		}
    }
	
//    public Usuario muestraUsuario(String username) {
//    
//    }

}
