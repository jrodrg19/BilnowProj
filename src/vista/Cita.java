package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import modelo.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class Cita {

	public JFrame frame;
		
	public static JButton btnEditarCita=null;
		
	public JCalendar calendario;
	
	public JPanel panel__Horas;
	
	public JButton btnGuardarCita;
	
	/**
	 * Create the application.
	 */
	public Cita(JButton boton_editar) {
		
		if(boton_editar!=null) {
			btnEditarCita=boton_editar;
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 928, 645);
		frame.getContentPane().setLayout(null);

		calendario=new JCalendar();	
		calendario.setBounds(461, 67, 420, 250);
		frame.getContentPane().add(calendario);
		
		JLabel lblInformacinMascota = new JLabel("Informaci\u00F3n Mascota");
		lblInformacinMascota.setBounds(24, 26, 384, 26);
		frame.getContentPane().add(lblInformacinMascota);
		
		/**
		 * 
		 */
		btnGuardarCita = new JButton("Guardar Cita");
		btnGuardarCita.setBounds(740, 529, 121, 23);
		frame.getContentPane().add(btnGuardarCita);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(461, 366, 420, 132);
		frame.getContentPane().add(scrollPane);
		
		panel__Horas = new JPanel();
		scrollPane.setViewportView(panel__Horas);
		
		panel__Horas.setLayout(null);
	
	}

	

}

