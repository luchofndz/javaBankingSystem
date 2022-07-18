package homebankingUserManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import validationsPackage.UsuarioDAOException;


public class UsuarioDAOH2Impl implements UsuarioDAO {
	
    public void crearTablaUsuarios() {
        try {
        	new UsuarioDAOCrudSQL().crearTablaUsuarios();
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }
    
    public void eliminarTablaUsuarios() {
        try {
        	new UsuarioDAOCrudSQL().eliminarTablaUsuarios();
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }

    public void crearUsuario(Usuario unUsuario) {
        String user = unUsuario.getUser();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();
        Integer dni = unUsuario.getDni();
        String address = unUsuario.getAddress();

        try {
			new UsuarioDAOCrudSQL().crearUsuario(user, email, pass, dni, address);
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }

    public void borraUsuario(String username) {
        try {
			new UsuarioDAOCrudSQL().borraUsuario(username);
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }

    public void actualizaUsuario(Usuario unUsuario) {
        String user = unUsuario.getUser();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();
        Integer dni = unUsuario.getDni();
        String address = unUsuario.getAddress();

        try {
			new UsuarioDAOCrudSQL().actualizaUsuario(user, email, pass, dni, address);
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
    }
    
    public List<Usuario> listaTodosLosUsuarios() {
    	List<Usuario> list = null;
        try {
        	list = new UsuarioDAOCrudSQL().listaTodosLosUsuarios();
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
		return list;
    }
	
    public Usuario muestraUsuario(String username) {
    	Usuario user = null;
        try {
        	user = new UsuarioDAOCrudSQL().muestraUsuario(username);
		} catch (UsuarioDAOException e) {
			new Modal().displayErrorModal(e.toString());
		}
		return user;
    }

	
}
