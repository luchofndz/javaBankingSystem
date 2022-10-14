package homebankingUserManagementSystem;

import java.util.List;

import validationsPackage.UsuarioDAOException;
import validationsPackage.UsuarioServicioException;

public class UserService {
	private UsuarioDAO dao = new UsuarioDAOH2Impl();

	public void crearTablaUsuarios() throws UsuarioServicioException {

    }
    
    public void eliminarTablaUsuarios() throws UsuarioServicioException {
   
    }

    public void crearUsuario(Usuario unUsuario) throws UsuarioServicioException {
        /*try {
			new UsuarioDAOCrudSQL().crearUsuario(user, email, pass, dni, address);
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}*/
    }

    public void borraUsuario(String username) throws UsuarioServicioException {
       
    }

    public void actualizaUsuario(Usuario unUsuario) throws UsuarioServicioException {
        try {
        	dao.actualizaUsuario(unUsuario);
		} catch (Exception e) {
			throw new UsuarioServicioException(e);
		}
        
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
