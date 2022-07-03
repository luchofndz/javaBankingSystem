package panelUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bankingProducts.ProductTableModel;
import bankingProducts.Producto;
import bankingProducts.ProductoDAO;
import bankingProducts.ProductoDAOMethods;
import homebankingUserManagementSystem.Modal;
import homebankingUserManagementSystem.UserManagementView;
import homebankingUserManagementSystem.Usuario;
import homebankingUserManagementSystem.UsuarioDAO;
import homebankingUserManagementSystem.UsuarioDAOH2Impl;
import homebankingUserManagementSystem.UsuarioTableModel;
import validationsPackage.PasswordValidator;
import validationsPackage.TextValidator;

public class panelUI extends JPanel implements ActionListener {
	private JTable tabla;
	private UsuarioTableModel modelo;
	private ProductTableModel modeloTablaProducto;

	private JScrollPane scrollPaneParaTabla;
	private JButton botonAgregar;
	private JButton botonBorrar;
	private JButton botonActualizar;
	private JButton botonExtra;
	private String typeOfPanel;
	
	private UsuarioDAO dao = new UsuarioDAOH2Impl();
	private ProductoDAO prodDao = new ProductoDAOMethods();

	public panelUI(String typeOfPanel, JButton addButton, JButton deleteButton, JButton updateButton, JButton extraButton) {
		super();
		this.typeOfPanel = typeOfPanel;
		armarPanel(addButton, deleteButton, updateButton, extraButton);
	}

	private void armarPanel(JButton addButton, JButton deleteButton, JButton updateButton, JButton extraButton) {
		this.setLayout(new FlowLayout());

		// UI definitions
		if (typeOfPanel == "userPanel") {
			modelo = new UsuarioTableModel();
			tabla = new JTable(modelo);
		} else {
			modeloTablaProducto = new ProductTableModel();
			tabla = new JTable(modeloTablaProducto);
		}
		
		scrollPaneParaTabla = new JScrollPane(tabla);
		this.add(scrollPaneParaTabla);
		
		JPanel panelBasico = new JPanel();
		JPanel aux = new JPanel();
		JLabel title = new JLabel("ADD, DELETE OR MODIFY USERS");
		aux.add(title);
		panelBasico.setLayout(new BorderLayout());
		panelBasico.add(aux, BorderLayout.NORTH);

		JLabel labelDescription = new JLabel("for delete or update please select a row");
		panelBasico.add(labelDescription, BorderLayout.SOUTH);

		botonBorrar = deleteButton;
		botonBorrar.addActionListener(this);
	
		botonActualizar = updateButton;
		botonActualizar.addActionListener(this);

		botonAgregar = addButton;
		botonAgregar.addActionListener(this);
		
		botonExtra = extraButton;
		botonExtra.addActionListener(this);
		
		JPanel auxCentro = new JPanel();
		auxCentro.add(botonBorrar);
		auxCentro.add(botonActualizar);
		auxCentro.add(botonAgregar);
		auxCentro.add(botonExtra);		
		auxCentro.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelBasico.add(auxCentro, BorderLayout.CENTER);
		this.add(panelBasico);
		
		if (typeOfPanel == "userPanel") {
			List<Usuario> lista = dao.listaTodosLosUsuarios();
			modelo.setContenido(lista);
			modelo.fireTableDataChanged();
		} else {
			List<Producto> lista = prodDao.listaTodosLosProductosDeUsuario();
			modeloTablaProducto.setContenido(lista);
			modeloTablaProducto.fireTableDataChanged();
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAgregar) {
			if (typeOfPanel == "userPanel") {
				Usuario userCreated = UserManagementView.agregarUsuario();
				
				if(userCreated != null) {
					// UI create
					modelo.getContenido().add(userCreated);
					modelo.fireTableDataChanged();
				}
			}
			else {
				prodDao.crearTablaProductos();
			}
		}
		
		if (e.getSource() == botonActualizar) {
			if (typeOfPanel == "userPanel") {
				int filaSeleccionada = this.tabla.getSelectedRow();
				Usuario usuarioSelected = this.modelo.getContenido().get(filaSeleccionada);
				List<Object> list = UserManagementView.actualizarUsuario(usuarioSelected.getUser());
				Usuario userModified = new Usuario(usuarioSelected.getUser(), (String) list.get(0), (String) list.get(1), (Integer) list.get(2), (String) list.get(3) );
				//new Usuario(usuarioSelected.getUser(), passwordInput, emailInput, dniInput, addressInput);
				
				// DB update
				dao.actualizaUsuario(userModified);
				
				// UI remove
				this.modelo.getContenido().remove(filaSeleccionada);
				
				// UI add
				modelo.getContenido().add(userModified);// UI add
	
				modelo.fireTableDataChanged();
			}
		}
		
		if(e.getSource() == botonBorrar) {
			int filaSeleccionada = this.tabla.getSelectedRow();
			Usuario usuario = this.modelo.getContenido().get(filaSeleccionada);
			
			// DB delete
			UserManagementView.borrarUsuario(usuario.getUser());
			
			// UI delete
			this.modelo.getContenido().remove(filaSeleccionada);
			modelo.fireTableDataChanged();
		} 
		if(e.getSource() == botonExtra) {
			if (typeOfPanel == "userPanel") {
				int filaSeleccionada = this.tabla.getSelectedRow();
				Usuario usuario = this.modelo.getContenido().get(filaSeleccionada);
				
				// Open view poduct for ser selected
				UserManagementView.abrirProducto(usuario.getUser());
			}
		} 
	}

	private Integer parseInt(String displayInputModal) {
		// TODO Auto-generated method stub
		return null;
	}
}