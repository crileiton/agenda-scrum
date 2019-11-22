/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Proyecto Empresa
 * Septiembre 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package proyecto.lista.mundo;


public class Persona {
	
	// - - - - - - - - - - - - - - - - - - - - - -
	// Atributos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * La cédula de la persona
	 */
	private String cedula;

	/**
	 * El nombre de la persona
	 */
	private String nombre;

	// - - - - - - - - - - - - - - - - - - - - - -
	// Métodos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * Constructor de la clase.
	 */
	public Persona(String laCedula, String elNombre){
		cedula = laCedula;
		nombre = elNombre; }

	/**
	 * Getter of the property <tt>cedula</tt>
	 * @return  Returns the cedula.
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Setter of the property <tt>cedula</tt>
	 * @param cedula  The cedula to set.
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Getter of the property <tt>nombre</tt>
	 * @return  Returns the nombre.
	 * @uml.property  name="nombre"
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter of the property <tt>nombre</tt>
	 * @param nombre  The nombre to set.
	 * @uml.property  name="nombre"
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
