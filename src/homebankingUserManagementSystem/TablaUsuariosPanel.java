package homebankingUserManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import validationsPackage.PasswordValidator;
import validationsPackage.TextValidator;

public class TablaUsuariosPanel extends JPanel implements ActionListener {

	/*private JTable tablaUsuarios;
	private UsuarioTableModel modelo;

	private JScrollPane scrollPaneParaTabla;
	private JButton botonAgregar;
	private JButton botonBorrar;
	private JButton botonActualizar;
	private JButton botonVerProductos;
	
	private UsuarioDAO dao = new UsuarioDAOH2Impl();

	public TablaUsuariosPanel() {
		super();
		armarPanel();
	}

	private void armarPanel() {
		this.setLayout(new FlowLayout());

		// UI definitions
		modelo = new UsuarioTableModel();
		tablaUsuarios = new JTable(modelo);
		scrollPaneParaTabla = new JScrollPane(tablaUsuarios);
		this.add(scrollPaneParaTabla);
		
		JPanel panelBasico = new JPanel();
		JPanel aux = new JPanel();
		JLabel title = new JLabel("ADD, DELETE OR MODIFY USERS");
		aux.add(title);
		panelBasico.setLayout(new BorderLayout());
		panelBasico.add(aux, BorderLayout.NORTH);

		JLabel labelDescription = new JLabel("for delete or update please select a row");
		panelBasico.add(labelDescription, BorderLayout.SOUTH);

		botonBorrar = new JButton("Borrar");
		botonBorrar.addActionListener(this);
		
		botonActualizar = new JButton("Actualizar");
		botonActualizar.addActionListener(this);

		botonAgregar = new JButton("Cargar nuevo");
		botonAgregar.addActionListener(this);
		
		botonVerProductos = new JButton("Ver productos");
		botonVerProductos.addActionListener(this);
		
		JPanel auxCentro = new JPanel();
		auxCentro.add(botonBorrar);
		auxCentro.add(botonActualizar);
		auxCentro.add(botonAgregar);
		auxCentro.add(botonVerProductos);		
		auxCentro.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelBasico.add(auxCentro, BorderLayout.CENTER);
		this.add(panelBasico);
		
		List<Usuario> lista = dao.listaTodosLosUsuarios();
		modelo.setContenido(lista);
		modelo.fireTableDataChanged();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAgregar) {
			// TODO: add validations for data
			String userInput = new Modal().displayInputModal("Please insert user name: ");
			
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
								Usuario userCreated = new Usuario(userInput, passwordInput, emailInput, dniInput, addressInput);
								
								// DB create
								dao.crearUsuario(userCreated);

								// UI create
								modelo.getContenido().add(userCreated);
								modelo.fireTableDataChanged();
							}
						}
					}
				}
			}
		} 
		
		if (e.getSource() == botonActualizar) {
			// TODO: add validations for data
			String emailInput = new Modal().displayInputModal("Please insert new user email: ");
				
			if (emailInput != null) {
				String passwordInput = new Modal().displayInputModal("Please insert new user password: ");
				
				if (passwordInput != null) {
					String addressInput = new Modal().displayInputModal("Please insert new user address: ");
					
					if (addressInput != null) {
						Integer dniInput = Integer.parseInt(new Modal().displayInputModal("Please insert new user DNI: "));
						
						if (dniInput != null) {
							int filaSeleccionada = this.tablaUsuarios.getSelectedRow();
							Usuario usuarioSelected = this.modelo.getContenido().get(filaSeleccionada);
							Usuario userModified = new Usuario(usuarioSelected.getUser(), passwordInput, emailInput, dniInput, addressInput);
							
							// DB update
							dao.actualizaUsuario(userModified);
							
							// UI remove
							this.modelo.getContenido().remove(filaSeleccionada);
							
							// UI add
							modelo.getContenido().add(userModified);
							modelo.fireTableDataChanged();
						}
					}
				}
			}

		} 
		
		if(e.getSource() == botonBorrar) {
			int filaSeleccionada = this.tablaUsuarios.getSelectedRow();
			Usuario usuario = this.modelo.getContenido().get(filaSeleccionada);
			
			// DB delete
			dao.borraUsuario(usuario.getUser());
			
			// UI delete
			this.modelo.getContenido().remove(filaSeleccionada);
			modelo.fireTableDataChanged();
		} else if(e.getSource() == botonVerProductos) {
			int filaSeleccionada = this.tablaUsuarios.getSelectedRow();
			Usuario usuario = this.modelo.getContenido().get(filaSeleccionada);
			
			// here call UI	
		} 
	}

	private Integer parseInt(String displayInputModal) {
		// TODO Auto-generated method stub
		return null;
	}
	*/

}