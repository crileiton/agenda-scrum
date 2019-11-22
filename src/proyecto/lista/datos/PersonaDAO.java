/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Proyecto Empresa
 * Septiembre 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package proyecto.lista.datos;

import java.sql.*;
import java.util.ArrayList;

import proyecto.lista.mundo.Persona;

public class PersonaDAO {

	// - - - - - - - - - - - - - - - - - - - - - -
	// Atributos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * La fechada a la Base de datos
	 */
	private FachadaDB fachada;


	// - - - - - - - - - - - - - - - - - - - - - -
	// Métodos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * El constructor de la clase PersonaDAO
	 */
	public PersonaDAO()
	{
		fachada = new FachadaDB();
	}

	/** 
	 * Consulta las personas.
	 * <br><b>post:</b> Se ha consultado y retornado las personas
	 * @return Lista de las personas.
	 * @throws SQLException. Lanza una excepción si no se ejecuta la sentencia sql.
	 * @throws ClassNotFoundException. Lanza una excepción, si no se conecta a la Base de datos.
	 */
	public ArrayList consultar()throws ClassNotFoundException, SQLException 
	{
		ArrayList personas = new ArrayList();
		String sqlConsultar = "SELECT cedula, nombre FROM persona ORDER BY cedula";
		Connection miConexion = fachada.conectar();
		if(miConexion != null)
		{
			Statement instruccion = miConexion.createStatement();
			ResultSet tabla = instruccion.executeQuery(sqlConsultar);
			while(tabla.next())
			{
				Persona persona = new Persona(tabla.getString("cedula"), tabla.getString("nombre"));
				personas.add(persona);
			}
			fachada.desconectar(miConexion);
		}
		return personas;
	}
}
