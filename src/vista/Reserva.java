package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import controlador.ControlAddProd;
import modelo.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;

public class Reserva {

	public JFrame frame;
	
	public JPanel panel;
	
	public JScrollPane scrollPane_1;

	public Usuario user=null;
	
	public JButton aniadir_Prod;

	public JButton btnEliminar;
	
	public JButton btnQuitarProducto;
	
	public JPanel panelObj;
	
	public JButton btnRealizarPedido;
	
	public JLabel lblCarritoDeLa;
	
	public JScrollPane scrollPane;
	
	/**
	 * Create the application.
	 * @param eliminar 
	 * @param aniadir 
	 * @wbp.parser.entryPoint
	 */
	public Reserva(JButton aniadir, JButton eliminar) {

		aniadir_Prod=aniadir;
		
		btnEliminar=eliminar;
				
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1046, 646);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);

		JLabel lblCarritoDeLa = new JLabel("Carrito de la compra");
		lblCarritoDeLa.setBounds(769, 35, 153, 14);
		frame.getContentPane().add(lblCarritoDeLa);

		btnRealizarPedido = new JButton("Realizar pedido");
		btnRealizarPedido.setBounds(880, 573, 112, 23);
		frame.getContentPane().add(btnRealizarPedido);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(24, 43, 600, 500);

		frame.getContentPane().add(scrollPane);
		
		//Crear array de todos los productos;

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(648, 60, 359, 483);
		frame.getContentPane().add(scrollPane_1);
	
		btnQuitarProducto = new JButton("Quitar Producto");
		btnQuitarProducto.setBounds(688, 573, 124, 23);
	
		frame.getContentPane().add(btnQuitarProducto);

		frame.repaint();
	}
		
}
