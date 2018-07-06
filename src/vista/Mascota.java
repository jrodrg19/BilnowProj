package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import controlador.ControlCita;
import modelo.*;
import javax.swing.JButton;

public class Mascota {

	public JFrame frame;
		
	public JPanel panel;
	
	public JButton btnBorrarCita;
	
	public JButton btnEditarCita;
	
	public JScrollPane scrollPane;
	
	/**
	 * Create the application.
	 * @param actual 
	 */
	public Mascota(modelo.Mascota actual) {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 499, 731);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(28, 403, 428, 169);
		frame.getContentPane().add(scrollPane);
		
		
		btnBorrarCita = new JButton("Borrar Cita");
		btnBorrarCita.setBounds(74, 595, 116, 42);
		
		
		btnEditarCita = new JButton("Editar Cita");
		btnEditarCita.setBounds(280, 595, 124, 42);			
					
	}
	
}
