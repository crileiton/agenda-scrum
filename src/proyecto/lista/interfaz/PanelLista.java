package proyecto.lista.interfaz;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import proyecto.lista.mundo.Empresa;
import proyecto.lista.mundo.Persona;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class PanelLista extends JPanel implements ActionListener
{
	
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el botón eliminar
     */
	private static final String ELIMINAR = "eliminar";


    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Modelo de la tabla del catálogo
     */
    private TablaModeloLista lista;
    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

	/**
	 * Tabla de la lista
	 */
    private JTable tablaLista;
    
    /**
     * Barra de desplazamiento
     */
    private JScrollPane desplazamientoPanel;
    
    /**
     * Ventana principal
     */
    private InterfazLista principal;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Método constructor del panel. <br>
     * <b>post: </b> Se inicializan los atributos del panel.
     * @param ventana La ventana principal de la interfaz.
     * @param empresa Instancia de la clase principal del mundo.
     */
	public PanelLista(InterfazLista ventana, Empresa empresa) 
	{
		principal = ventana;
		
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(null);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand(ELIMINAR);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(400, 50, 90, 30);
		add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(400, 85, 90, 30);
		add(btnCancelar);
		
		lista = new TablaModeloLista(empresa);
		tablaLista = new JTable(lista);
		
		// El JTable no muestra los nombres de las columnas lo hace el JScrollPane
		desplazamientoPanel = new JScrollPane( tablaLista );
		desplazamientoPanel.setBounds(10, 40, 360, 110);
		add(desplazamientoPanel);
		actualizarLista();

	}
	
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información de la lista
     */
    public void actualizarLista( )
    {
    	lista.fireTableDataChanged();
    }

	/**
	 * Manejo de los eventos en los botones
	 */
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	String comando = e.getActionCommand();
    	if(comando.equals(ELIMINAR))
    	{
    		//Sacar el elemento de la lista
    		Persona persona = null;
    		try
    		{
    			persona = (Persona) tablaLista.getValueAt(tablaLista.getSelectedRow(), -1);
    		}
    		catch(Exception exc)
    		{
    			JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento de la lista", "Ejemplo Lista", JOptionPane.ERROR_MESSAGE);
    		}
    		principal.eliminarElemento(persona);
    	}
	}
}
