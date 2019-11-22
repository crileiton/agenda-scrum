package proyecto.lista.interfaz;

import javax.swing.table.AbstractTableModel;

import proyecto.lista.mundo.Empresa;
import proyecto.lista.mundo.Persona;

public class TablaModeloLista extends AbstractTableModel {


	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Títulos de las columnas
	 */
	private String[] nombreColumnas;

	/**
	 * Empresa
	 */
	private Empresa empresa;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Método constructor del AbstractableModel. <br>
	 * <b>post: </b> Se inicializan los atributos de la clase.
	 * @param laEmpresa Instancia de la clase principal del mundo laEmpresa != null
	 */
	public TablaModeloLista(Empresa laEmpresa)
	{
		super();
		empresa = laEmpresa;
		String[] nombreColumnasAux = { "Cédula" , "Nombre" };
		nombreColumnas = nombreColumnasAux;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Sobrecarga el método de Table Model y retorna el número de filas para ajustar la tabla de personas.
	 * @return número de filas.
	 */
	public int getRowCount() {
		// TODO Auto-generated method stub
		return empresa.getPersonas().size();
	}

	/**
	 * Sobrecarga el método de Table Model y retorna el número de columnas para ajustar la tabla de personas.
	 * @return número de columnas.
	 */
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nombreColumnas.length;
	}

	/**
	 * Sobrecarga el método de Table Model y retorna el objeto de la casilla indicada.
	 * @param rowIndex Índice de la fila. rowIndex >= 0.
	 * @param columnIndex Índice de la columna. columnIndex >= -1.
	 * @return dato de la celda. Si columnIndex es -1 retorna el objeto de la persona completo.
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object datoPersona = null;
		Object[] personas = empresa.getPersonas().toArray();
		Persona persona = (Persona) personas[rowIndex];
		if (columnIndex == -1)
		{
			datoPersona = persona;
		}
		else if (columnIndex == 0)
		{
			datoPersona = persona.getCedula();
		}
		else if(columnIndex == 1)
		{
			datoPersona = persona.getNombre();
		}
		return datoPersona;
	}

	/**
	 * Sobrecarga el método de Table Model y retorna el nombre de la columna.
	 * @param columnIndex Columna de la cual se quiere saber el nombre. columnIndex >= 0.
	 * @return nombre de la columna
	 */
	public String getColumnName( int columnIndex )
	{
		return nombreColumnas[ columnIndex ];
	}

}
