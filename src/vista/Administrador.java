package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import controlador.ControlUser;
import modelo.*;

import javax.swing.JPanel;

/**
 * 
 * @author Javier
 *
 */
public class Administrador {

	public JFrame frame;
	public JTextField textnom;
	public JTextField Apellido;
	public JTextField textDireccion;
	public JTextField textTelefono;
	public JTextField textEmail;
	public JTextField textDni;
	public JTextField textField;
	public Usuario administrador;
	public JMenuItem mntmAadirCliente;
	public JMenuItem mntmAadirProducto;
	public JMenuItem mntmSalir;
	public JButton btnBuscar;
	public JButton btnAadirCliente;
	public JButton btnAniadirProducto;
	
	/**
	 * Initialize the contents of the frame.
	 */
	public Administrador() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 354);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 642, 449);
		panel.setLayout(null);
		
			
		JPanel panel_Cli = new JPanel();
		panel_Cli.setBounds(0, 0, 642, 449);
		panel_Cli.setLayout(null);
				
			
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		/**
		 * 
		 * Crea una pesaña en el menu
		 * 
		 */
		mntmAadirCliente = new JMenuItem("A\u00F1adir Cliente");
		mnInicio.add(mntmAadirCliente);	
		
		mntmAadirProducto = new JMenuItem("A\u00F1adir Producto");
		mnInicio.add(mntmAadirProducto);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false);
			
			}
		});
		mnInicio.add(mntmSalir);
		
		JMenu mnOpcionesAdmin = new JMenu("Opciones Admin");
		menuBar.add(mnOpcionesAdmin);
		
		JMenuItem mntmBackup = new JMenuItem("Backup");
		mntmBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AccesoBD consulta=new AccesoBD();
				
				JFileChooser fileChooser = new JFileChooser();
			    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			    
			    int result = fileChooser.showSaveDialog(mntmBackup);

			    File fileName=null;
			    
			    if (result != JFileChooser.CANCEL_OPTION) {

			        fileName = fileChooser.getSelectedFile();

					consulta.backupBD(fileName);
					
			    }
								
			}
		});
		mnOpcionesAdmin.add(mntmBackup);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultarCliente = new JLabel("Consultar cliente");
		lblConsultarCliente.setBounds(38, 215, 126, 14);
		frame.getContentPane().add(lblConsultarCliente);
		
		textField = new JTextField();
		textField.setBounds(104, 237, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(200, 236, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		btnAadirCliente = new JButton("A\u00F1adir cliente");
		btnAadirCliente.setBounds(95, 50, 169, 38);
		frame.getContentPane().add(btnAadirCliente);
		
		JLabel lblDni_1 = new JLabel("DNI");
		lblDni_1.setBounds(66, 240, 46, 14);
		frame.getContentPane().add(lblDni_1);
		
		btnAniadirProducto = new JButton("A\u00F1adir producto");
		btnAniadirProducto.setBounds(95, 114, 169, 38);
		frame.getContentPane().add(btnAniadirProducto);
	}
}
