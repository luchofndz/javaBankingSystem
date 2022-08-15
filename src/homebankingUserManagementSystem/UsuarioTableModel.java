package homebankingUserManagementSystem;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {
	
	/**
	 * INDICES DE MIS COLUMNAS
	 */
	private static final int COLUMNA_LOGIN = 0;
	private static final int COLUMNA_NOMBRE = 1;
	private static final int COLUMNA_EMAIL = 2;
	private static final int COLUMNA_DNI = 3;
	private static final int COLUMNA_ADDRESS = 4;
	
	/**
	 * NOMBRES DE LOS ENCABEZADOS
	 */
	private String[] nombresColumnas = {"Login", "Nombre", "Email", "Dni", "Adress"};
	
	/**
	 * TIPOS DE CADA COLUMNA (EN EL MISMO ORDEN DE LOS ENCABEZADOS)
	 */
	private Class[] tiposColumnas = {String.class, String.class, String.class, Integer.class, String.class};
	

	private List<Usuario> contenido;
	
	/**
	 * CONSTRUCTOR VACIO
	 */
	public UsuarioTableModel() {
		contenido = new ArrayList<Usuario>();
	}
	
	/**
	 * CONSTRUCTOR CON CONTENIDO INICIAL
	 * @param contenidoInicial
	 */
	public UsuarioTableModel(List<Usuario> contenidoInicial) {
		contenido = contenidoInicial;
	}

	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public int getColumnCount() {
		return nombresColumnas.length;
	}

	/**
	 * OTRO METODO QUE HAY QUE PISAR
	 */
	public int getRowCount() {
		return contenido.size();
	}
	
	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public String getColumnName(int col) {
        return nombresColumnas[col];
    }

	/**
	 * METODO QUE HAY QUE PISAR
	 */
    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }
    
	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Usuario u = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_LOGIN:
			result = u.getUser();
			break;
		case COLUMNA_NOMBRE:
			result = u.getUser();
			break;
		case COLUMNA_EMAIL:
			result = u.getEmail();
			break;
		case COLUMNA_DNI:
			result = u.getDni();
			break;
		case COLUMNA_ADDRESS:
			result = u.getAddress();
			break;
		default:
			result = new String("");
		}
		
		return result;
	}

    
    /**
     * GETTER DE MIS FILAS
     * @return
     */
    public List<Usuario> getContenido() {
    	return contenido;
    }
    /**
     * SETTER DE MIS FILAS 
     * 
     * @param contenido
     */
    public void setContenido(List<Usuario> contenido) {
    	this.contenido = contenido;
    }
}