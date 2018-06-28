package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.AccesoBD;
import modelo.Mascota;
import modelo.Usuario;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

	public static JFrame frame;
	public JTextField textDni;
	public JTextField textDireccion;
	public JTextField textNombre;
	public JTextField textCorreo;
	public JTextField textTlfn;
	public Usuario cliente;
	public Mascota mascota_Control;
	public JButton btnPedirCita;
	public int pos_Mascota;
	public int pos;
	public JTextField textField;
	public JTextField textField_1;
	public JButton eliminar_Masc;
	public JButton aniadir_Masc;
	public JButton eliminar_Usuario;
	public JButton btnCatalogo;
	public JButton btnVercitas;
	public Mascota actual;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param user 
	 * @param buttoneliminar 
	 * @param btnagregarButton 
	 * @param eliminarUser 
	 */
	public Cliente(Usuario user, JButton btnagregarButton, JButton buttoneliminar, JButton eliminarUser) {
		eliminar_Usuario=eliminarUser;
		eliminar_Masc=buttoneliminar;
		aniadir_Masc=btnagregarButton;
		this.cliente=user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		mascota_Control=new Mascota();
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
		textDni.setText(cliente.getDni_usuario());
		//mostrar_Mascotas();

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(29, 105, 66, 14);
		frame.getContentPane().add(lblDireccion);

		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setBounds(146, 103, 362, 17);
		frame.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		textDireccion.setText(cliente.getDireccion_usuario());

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 45, 66, 14);
		frame.getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(146, 43, 251, 17);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		textNombre.setText(cliente.getNombre_usuario());

		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(29, 133, 107, 17);
		frame.getContentPane().add(lblCorreoElectronico);

		textCorreo = new JTextField();
		textCorreo.setEditable(false);
		textCorreo.setBounds(146, 131, 362, 20);
		frame.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		textCorreo.setText(cliente.getEmail_usuario());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(29, 183, 761, 248);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		btnCatalogo = new JButton("Cat\u00E1logo");


		
		btnCatalogo.setBounds(565, 54, 209, 55);
		frame.getContentPane().add(btnCatalogo);
		
		JLabel lblTlfn = new JLabel("Tel\u00E9fono:");
		lblTlfn.setBounds(256, 74, 66, 14);
		frame.getContentPane().add(lblTlfn);
		
		textTlfn = new JTextField();
		textTlfn.setText(cliente.getTlf_Usuario());
		textTlfn.setEditable(false);
		textTlfn.setColumns(10);
		textTlfn.setBounds(323, 72, 74, 17);
		frame.getContentPane().add(textTlfn);

		
		if(eliminar_Masc!=null&&aniadir_Masc!=null) {
			
			eliminar_Usuario.setBounds(29, 448, 178, 30);
			frame.getContentPane().add(eliminar_Usuario);
			
			aniadir_Masc.setBounds(677, 133, 46, 39);
			frame.getContentPane().add(aniadir_Masc);
			
			eliminar_Masc.setBounds(741, 133, 46, 39);
			frame.getContentPane().add(eliminar_Masc);
		}
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Inicio");
		menuBar.add(menu);
		
	JMenuItem  mntmVerCatlogo = new JMenuItem("Ver Cat\u00E1logo");
		menu.add(mntmVerCatlogo);
	mntmVerCatlogo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Reserva verCatalogo=new Reserva(cliente,null,null);
				verCatalogo.main(null);
			}
		});;
	
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false);
			
			}
		});
		menu.add(mntmSalir);
		
				
		pos=0;
		
		for(int i=0;i<cliente.get_NumMascotas();i++) {
			
			actual=cliente.getMascota(i);	
			
			modelo.Cita control_Cita=new modelo.Cita(actual.getDni_Mascota());
			JPanel panel_Mascota = new JPanel();
			panel_Mascota.setBackground(Color.WHITE);
			panel_Mascota.setBounds(0, pos, 751, 41);
			panel_Mascota.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					frame.getContentPane().add(btnPedirCita);

					int pos=panel_Mascota.getY();
					
					if(pos!=0) {
						pos_Mascota=(pos+1)%41;
					}
					else {
						pos_Mascota=pos%10;
					}
					
					frame.repaint();
					
				}
			});
			panel.add(panel_Mascota);
			panel_Mascota.setLayout(null);
			
			JLabel nom_Mascota = new JLabel("New label");
			nom_Mascota.setBounds(33, 11, 46, 14);
			panel_Mascota.add(nom_Mascota);
			
			nom_Mascota.setText(actual.getDni_Mascota());
			
			if(control_Cita.getNumCitas()>0) {
				btnVercitas = new JButton("Ver cita");
				btnVercitas.setBounds(633, 7, 89, 23);
				panel_Mascota.add(btnVercitas);
			}
				
			pos=pos+41;
		}
		
	}
}
