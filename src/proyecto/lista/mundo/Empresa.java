package proyecto.lista.mundo;

import java.sql.SQLException;
import java.util.ArrayList;

import proyecto.lista.datos.PersonaDAO;


public class Empresa {

	// - - - - - - - - - - - - - - - - - - - - - -
	// Atributos
	// - - - - - - - - - - - - - - - - - - - - - -
	
	/**
	 * Lista de las personas de la empresa
	 */
	private ArrayList personas;

	/**
	 * Objeto que permite realizar operaciones con la Base de datos
	 */
	private PersonaDAO personaDAO;


	// - - - - - - - - - - - - - - - - - - - - - -
	// Métodos
	// - - - - - - - - - - - - - - - - - - - - - -
	
	/**
	 * Constructor de la clase
	 * @throws SQLException. Lanza una excepción si no se ejecuta la sentencia sql.
	 * @throws ClassNotFoundException. Lanza una excepción, si no se conecta a la Base de datos.
	 */
	public Empresa() throws ClassNotFoundException, SQLException{
		personas = new ArrayList();
		personaDAO = new PersonaDAO();
		cargarPersonas();
	}


	/**
	 * Carga las personas en la lista personas.
	 * <b>post:<b> Se cargó los datos de las personas almacenados en la base de datos en la lista personas.
	 * @throws SQLException. Lanza una excepción si no se ejecuta la sentencia sql.
	 * @throws ClassNotFoundException. Lanza una excepción, si no se conecta a la Base de datos.
	 */
	public void cargarPersonas() throws ClassNotFoundException, SQLException{
		setPersonas(personaDAO.consultar());
	}

	/**
	 * Elimina una persona de la lista de personas dada su cédula
	 * <b>pre:<b> La lista personas existe y está inicializada.
	 * <b>post:<b> Se eliminó la persona de la lista personas.
	 * @param cedula El número de cédula de la persona a eliminar  cedula != null && cedula != "" 
	 */
	public void elminarPersona(String cedula)
	{
		boolean encontrado = false;
		for(int indice = 0; indice < personas.size() && !encontrado; indice ++)
		{
			Persona persona = (Persona) personas.get(indice);
			if(persona.getCedula().equals(cedula))
			{
				encontrado = true;
				personas.remove(indice);
			}
		}
	}
	
	/**
	 * Getter of the property <tt>personas</tt>
	 * @return  Returns the personas.
	 * @uml.property  name="personas"
	 */
	public ArrayList getPersonas() {
		return personas;
	}

	/**
	 * Setter of the property <tt>personas</tt>
	 * @param personas  The personas to set.
	 * @uml.property  name="personas"
	 */
	public void setPersonas(ArrayList personas) {
		this.personas = personas;
	}

}
