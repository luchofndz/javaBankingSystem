package bankingProducts;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {
	/**
	 * INDICES DE MIS COLUMNAS
	 */
	private static final int COLUMNA_TIPO = 0;
	private static final int COLUMNA_NUMERO = 1;
	private static final int COLUMNA_ALIAS = 2;
	private static final int COLUMNA_DEBITO = 3;
	private static final int COLUMNA_CREDITO = 4;
	private static final int COLUMNA_TOTAL = 5;
	
	/**
	 * NOMBRES DE LOS ENCABEZADOS
	 */
	private String[] nombresColumnas = {"CtaTipo", "Numero", "Alias", "Debito", "Credito", "Total"};
	
	/**
	 * TIPOS DE CADA COLUMNA (EN EL MISMO ORDEN DE LOS ENCABEZADOS)
	 */
	private Class[] tiposColumnas = {String.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class};
	

	private List<Producto> contenido;
	
	/**
	 * CONSTRUCTOR VACIO
	 */
	public ProductTableModel() {
		contenido = new ArrayList<Producto>();
	}
	
	/**
	 * CONSTRUCTOR CON CONTENIDO INICIAL
	 * @param contenidoInicial
	 */
	public ProductTableModel(List<Producto> contenidoInicial) {
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
		
		Producto u = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_TIPO:
			result = u.getCuentaTipo();
			break;
		case COLUMNA_NUMERO:
			result = u.getNumero();
			break;
		case COLUMNA_ALIAS:
			result = u.getAlias();
			break;
		case COLUMNA_DEBITO:
			result = u.getDebito();
			break;
		case COLUMNA_CREDITO:
			result = u.getCredito();
			break;
		case COLUMNA_TOTAL:
			result = u.getTotal();
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
    public List<Producto> getContenido() {
    	return contenido;
    }
    /**
     * SETTER DE MIS FILAS 
     * 
     * @param contenido
     */
	public void setContenido(List<Producto> contenido) {
    	this.contenido = contenido;
    }
}