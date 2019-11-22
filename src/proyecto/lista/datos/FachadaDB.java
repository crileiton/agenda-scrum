/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Proyecto Empresa
 * Septiembre 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package proyecto.lista.datos;

import java.sql.*;

public class FachadaDB {
	// - - - - - - - - - - - - - - - - - - - - - -
	// Constantes
	// - - - - - - - - - - - - - - - - - - - - - -
    /**
     * Driver de conexión a la base de datos
     */
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
    /**
     * La cadena de conexión a la base de datos que incluye la zona horaria
     */
	public static final String URL = "jdbc:mysql://localhost:3306/empresa?serverTimezone=UTC";
	
    /**
     * Nombre del usuario con el que se conecta a la base de datos
     */
	public static final String USUARIO = "root";
	
    /**
     * Clave de acceso a la base de datos
     */
	public static final String PASSWORD = "";

	// - - - - - - - - - - - - - - - - - - - - - -
	// Atributos
	// - - - - - - - - - - - - - - - - - - - - - -
    /**
     * La cadena de conexión a la base de datos que incluye la zona horaria
     */
	private String url;
	
    /**
     * Nombre del usuario con el que se conecta a la base de datos
     */
	private String usuario;
	
    /**
     * Clave de acceso a la base de datos
     */
	private String password;
	
    /**
     * Objeto que mantiene la conexión a la base de datos
     */
	private Connection conexion;

	// - - - - - - - - - - - - - - - - - - - - - -
	// Métodos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * El constructor de la clase FachadaBD
	 */
	public FachadaDB()
	{
		url = URL;
		usuario = USUARIO;
		password = PASSWORD;
		conexion = null;
	}
	
	/**
	 * Crea un objetivo de tipo conexión con la base de datos
	 * @return retorna el objetivo de tipo conexión
	 * @throws SQLException. Lanza una excepción si no se ejecuta la sentencia sql.
	 * @throws ClassNotFoundException. Lanza una excepción, si no se conecta a la Base de datos.
	 */
	public Connection conectar() throws SQLException, ClassNotFoundException 
	{
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(url,usuario,password);
		return conexion;
	}
	
	/**
	 * Cierra una conexión a la base de datos.
	 * @param laConexion, El objeto de tipo conexión laConexion!=null
	 * @throws SQLException. Lanza una excepción si no se ejecuta la sentencia sql.
	 */
	public void desconectar(Connection laConexion) throws SQLException
	{
		laConexion.close();
	}
}
