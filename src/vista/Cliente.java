package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.*;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;

public class Cliente {

	public JFrame frame;
	public JTextField textDni;
	public JTextField textDireccion;
	public JTextField textNombre;
	public JTextField textCorreo;
	public JTextField textTlfn;
	public modelo.Mascota mascota_Control;
	public int pos_Mascota;
	public int pos;
	public JTextField textField;
	public JTextField textField_1;
	public JButton eliminar_Masc;
	public JButton aniadir_Masc;
	public JButton eliminar_Usuario;
	public JButton btnPedirCita;
	public JButton btnCatalogo;
	public JMenuItem mntmVerCatlogo;
	public JMenuItem mntmSalir;
	public JPanel panel_Mascota;
	public JButton btnVercitas;
	public JPanel panel;
	public JScrollPane scrollPane;
	
	/**
	 * Create the application.
	 * @param user 
	 * @param buttoneliminar 
	 * @param btnagregarButton 
	 * @param eliminarUser 
	 */
	public Cliente(JButton btnagregarButton, JButton buttoneliminar, JButton eliminarUser) {
		eliminar_Usuario=eliminarUser;
		eliminar_Masc=buttoneliminar;
		aniadir_Masc=btnagregarButton;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		mascota_Control=new modelo.Mascota();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);

		frame.setBounds(100, 100, 830, 562);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnPedirCita = new JButton("Pedir cita");
		btnPedirCita.setBounds(659, 459, 134, 39);

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(29, 74, 46, 14);
		frame.getContentPane().add(lblDni);

		textDni = new JTextField();
		textDni.setEditable(false);
		textDni.setBounds(146, 71, 86, 20);
		frame.getContentPane().add(textDni);
		textDni.setColumns(10);
		//mostrar_Mascotas();

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(29, 105, 66, 14);
		frame.getContentPane().add(lblDireccion);

		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setBounds(146, 103, 362, 17);
		frame.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 45, 66, 14);
		frame.getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(146, 43, 251, 17);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(29, 133, 107, 17);
		frame.getContentPane().add(lblCorreoElectronico);

		textCorreo = new JTextField();
		textCorreo.setEditable(false);
		textCorreo.setBounds(146, 131, 362, 20);
		frame.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(29, 183, 761, 248);
		frame.getContentPane().add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		btnCatalogo = new JButton("Catalogo");
		
		btnCatalogo.setBounds(565, 54, 209, 55);
		frame.getContentPane().add(btnCatalogo);
		
		JLabel lblTlfn = new JLabel("Telefono:");
		lblTlfn.setBounds(256, 74, 66, 14);
		frame.getContentPane().add(lblTlfn);
		
		textTlfn = new JTextField();
		textTlfn.setEditable(false);
		textTlfn.setColumns(10);
		textTlfn.setBounds(323, 72, 74, 17);
		frame.getContentPane().add(textTlfn);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Inicio");
		menuBar.add(menu);
		
		mntmVerCatlogo = new JMenuItem("Ver Cat\u00E1logo");
		menu.add(mntmVerCatlogo);
		
		mntmSalir = new JMenuItem("Salir");
		menu.add(mntmSalir);
		
	}

	public void setPanelMascota(JPanel panel_Mascota) {
		
		this.panel_Mascota=panel_Mascota;
		panel.add(panel_Mascota);
		frame.repaint();
		
	}
}
