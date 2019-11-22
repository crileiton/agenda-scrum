package proyecto.lista.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.lista.mundo.Empresa;
import proyecto.lista.mundo.Persona;

public class InterfazLista extends JFrame {
	

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------
	/**
	 * Panel para cargar la Tabla
	 */
	private PanelLista panelLista;
	
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	/**
	 * Clase principal del mundo
	 */
	private Empresa empresa;
	


    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Método constructor de la ventana. <br>
     * <b>post: </b> Se inicializan los paneles con la información del sistema
     */
	public InterfazLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		setLayout(new BorderLayout(0, 0));
		
		// Inicializar la clase principal del mundo
		try {
			empresa = new Empresa();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
		
		// Agregar los paneles		
		panelLista = new PanelLista(this, empresa);
		add(panelLista, BorderLayout.CENTER);
	}
	
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	/**
	 * Elimina una persona de la lista de personas. <br>
	 * <b>post:</b> Eliminó la persona de la lista de personas y actualizó la tabla.
	 * @param persona La persona a eliminar
	 */
	public void eliminarElemento(Persona persona)
	{
		if(persona != null)
		{
			String mensaje = "La persona que se eliminará de la lista es C.C. " + persona.getCedula() + " Nombre " + persona.getNombre(); 
			JOptionPane.showMessageDialog(this, mensaje, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);
			empresa.elminarPersona(persona.getCedula());
			panelLista.actualizarLista();
		}
	}
	
    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Argumentos
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLista frame = new InterfazLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
