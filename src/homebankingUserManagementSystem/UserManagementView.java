package homebankingUserManagementSystem;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bankingProducts.ProductoDAO;
import bankingProducts.ProductoDAOMethods;
import panelUI.panelUI;
import validationsPackage.PasswordValidator;
import validationsPackage.TextValidator;

public class UserManagementView {
	private static UsuarioDAO dao = new UsuarioDAOH2Impl();
	private static ProductoDAO daoProducto = new ProductoDAOMethods();


	public void displayView() {
		// Initialize table definition for user
		dao.crearTablaUsuarios();
		
		this.displayLoginView();
    }
	
	public void displayLoginView() {
		Modal userModal = new Modal();
		String userInput = userModal.displayInputModal("Welcome to the homebanking user management system, please insert admin user: ");
		// TODO: Add validations here
		
		Modal passwordModal = new Modal();
		String passwordInput = userModal.displayInputModal("Welcome " + userInput + ", please insert the password: ");
		// TODO: Add validations here
		
		
		// TODO: Add conditions, if all ok display view
		this.displayUserManagementView();
    }
	
	public void displayUserManagementView() {
		JFrame j = new JFrame("HOMEBANKING USER MANAGEMENT SYSTEM");
		// j.getContentPane().add(new TablaUsuariosPanel());
		j.getContentPane().add(
			new panelUI(
				"userPanel", 
				new JButton("Cargar nuevo"), 
				new JButton("Borrar"),
				new JButton("Actualizar"),
				new JButton("Ver productos")
			)
		);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.pack();
		j.setVisible(true);
    }
	
	public static Usuario agregarUsuario() {
		// TODO: add validations for data
		String userInput = new Modal().displayInputModal("Please insert user name: ");
		Usuario userCreated = null;
		
		// Validation User Name
		Boolean validUserName = false;
		do {
			try {
				TextValidator.validateStringLength(userInput, 256, 0);
				validUserName = true;
			} catch (Exception error) {
				new Modal().displayErrorModal(error.toString());
				validUserName = false;
				userInput = new Modal().displayInputModal("Please insert again user name: ");
			}
		} while(validUserName == false);
		
		if (userInput != null) {
			String emailInput = new Modal().displayInputModal("Please insert user email: ");
			
			if (emailInput != null) {
				String passwordInput = new Modal().displayInputModal("Please insert user password: ");
				
				// Validation Password
				Boolean validPassword = false;
				do {
					try {
						PasswordValidator.validatePassword(passwordInput);
						validPassword = true;
					} catch (Exception error) {
						new Modal().displayErrorModal(error.toString());
						validPassword = false;
						passwordInput = new Modal().displayInputModal("Please insert user password: ");
					}
				} while(validPassword == false);
				
				
				if (passwordInput != null) {
					String addressInput = new Modal().displayInputModal("Please insert user address: ");
					
					if (addressInput != null) {
						Integer dniInput = Integer.parseInt(new Modal().displayInputModal("Please insert user DNI: "));
						
						if (dniInput != null) {
							userCreated = new Usuario(userInput, passwordInput, emailInput, dniInput, addressInput);
							
							// DB create
							dao.crearUsuario(userCreated);
						}
					}
				}
			}
		}
		return(userCreated);
	}
	
	public static void borrarUsuario(String usuario) {
		
		// DB delete
		dao.borraUsuario(usuario);
	}
	
	public static List<Object> actualizarUsuario(String usuario) {
		// TODO: add validations for data
		String emailInput = new Modal().displayInputModal("Please insert new user email: ");
			
		if (emailInput != null) {
			String passwordInput = new Modal().displayInputModal("Please insert new user password: ");
			
			if (passwordInput != null) {
				String addressInput = new Modal().displayInputModal("Please insert new user address: ");
				
				if (addressInput != null) {
					Integer dniInput = Integer.parseInt(new Modal().displayInputModal("Please insert new user DNI: "));
					
					if (dniInput != null) {
						return Arrays.asList(passwordInput, emailInput, dniInput, addressInput);
					}
				}
			}
		}
		return null;
	}
	
	public static void abrirProducto(String usuario) {

		// Initialize table definition for user
		daoProducto.crearTablaProductos();
		
		JFrame j = new JFrame("PRODUCT VIEW FOR USER: " + usuario);
		// j.getContentPane().add(new TablaUsuariosPanel());
		j.getContentPane().add(
			new panelUI(
				"productPanel", 
				new JButton("Cargar nuevo"), 
				new JButton("Borrar"),
				new JButton("Actualizar"),
				new JButton("cerrar")
			)
		);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.pack();
		j.setVisible(true);
	}
}
