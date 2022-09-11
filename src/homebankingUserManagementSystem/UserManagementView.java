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
		
		// open selection mode (user or admin)
		this.displaySelectionModeView();
		
	
    }
	
	public void displaySelectionModeView() {		
		JFrame j = new JFrame("WELCOME TO THE HOMEBANKING SYSTEM");
		j.getContentPane().add(
			new panelUI(
				"modeSelectionPanel", 
				new JButton("I am user"), 
				new JButton("I am admin"),
				new JButton(""),
				new JButton("")
			)
		);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.pack();
		j.setVisible(true);
    }
	
	public static void displayLoginView(boolean isUser) {
		Modal userModal = new Modal();
		String userInput = userModal.displayInputModal("Welcome to the homebanking user management system, please insert user: ");
		
		if (isUser) {
			Boolean validUserName = false;
			Usuario user = null;
			do {
				user = dao.muestraUsuario(userInput);
				if(user != null) {
					validUserName = true;
				}
				else {
					new Modal().displayErrorModal("Invalid user, please type a valid user...");
					validUserName = false;
					userInput = new Modal().displayInputModal("Please insert again user name: ");
				}
			} while(validUserName.equals(false));
			if (validUserName) {
				Modal passwordModal = new Modal();
				String passwordInput = userModal.displayInputModal("Welcome " + userInput + ", please insert the password: ");
				
				Boolean validPassword = false;
				String passwordDb = user.getPass();
				System.out.println(passwordInput);
				do {
					if(passwordDb.equals(passwordInput)) {
						validPassword = true;
						System.out.println("yes");
					}
					else {
						new Modal().displayErrorModal("Invalid password, please type a valid password...");
						validPassword = false;
						passwordInput = new Modal().displayInputModal("Please insert again user password: ");
					}
				} while(validPassword.equals(false));
				if (validPassword) {
					UserManagementView.displayUserView(userInput);
				}
			}
		} else { 
			Modal passwordModal = new Modal();
			String passwordInput = userModal.displayInputModal("Welcome " + userInput + ", please insert the password: ");
			// TODO: Add validations here
			
			// TODO: Add conditions, if all ok display view
			//this.displayUserManagementView();
			
			UserManagementView view = new UserManagementView();
			view.displayUserManagementView();
		}
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
		} while(validUserName.equals(false));
		
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
				} while(validPassword.equals(false));
				
				
				if (passwordInput != null) {
					String addressInput = new Modal().displayInputModal("Please insert user address: ");
					
					if (addressInput != null) {
						Integer dniInput = Integer.parseInt(new Modal().displayInputModal("Please insert user DNI: "));
						
						if (dniInput != null) {
							userCreated = new Usuario(userInput, emailInput, passwordInput, dniInput, addressInput);
							
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
	

	public static void displayUserView(String user) {
		daoProducto.crearTablaProductos();
		
		JFrame j = new JFrame("PRODUCTS VIEW FOR USER: " + user);

		j.getContentPane().add(
			new panelUI(
				"productsUserPanel", 
				new JButton("Transferir"), 
				new JButton(""),
				new JButton(""),
				new JButton("cerrar")
			)
		);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.pack();
		j.setVisible(true);
	}
}
