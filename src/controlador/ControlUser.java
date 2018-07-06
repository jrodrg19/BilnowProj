package controlador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import modelo.Mascota;
import modelo.Usuario;
import vista.Aniadirmascota;
import vista.Cita;
import vista.Cliente;
import vista.Reserva;

public class ControlUser extends WindowAdapter implements ActionListener{

	private Usuario cliente;
	private Cliente winUser;
	public int pos_Mascota;

	public ControlUser(Usuario user, Cliente nC) {
		// TODO Auto-generated constructor stub

		this.winUser=nC;
		this.cliente=user;
		winUser.frame.addWindowListener(this);

	}

	public void windowOpened(WindowEvent e) {

		winUser.textDni.setText(cliente.getDni_usuario());
		winUser.textDireccion.setText(cliente.getDireccion_usuario());
		winUser.textNombre.setText(cliente.getNombre_usuario());
		winUser.textCorreo.setText(cliente.getEmail_usuario());
		winUser.textTlfn.setText(cliente.getTlf_Usuario());

		winUser.btnPedirCita.addActionListener(this);
		winUser.btnCatalogo.addActionListener(new Catalogo(winUser,cliente));
		winUser.mntmVerCatlogo.addActionListener(new Catalogo(winUser, cliente));
		winUser.mntmSalir.addActionListener(new Salir(winUser));

		int pos=0;

		for(int i=0;i<cliente.get_NumMascotas();i++) {

			Mascota actual=cliente.getMascota(i);	

			modelo.Cita control_Cita=new modelo.Cita(actual.getDni_Mascota());
			JPanel panel_Mascota = new JPanel();
			panel_Mascota.setBackground(Color.WHITE);
			panel_Mascota.setBounds(0, pos, 751, 41);
			panel_Mascota.addMouseListener(new Capturador(winUser));
			panel_Mascota.setLayout(null);

			JLabel nom_Mascota = new JLabel("New label");
			nom_Mascota.setBounds(33, 11, 46, 14);
			panel_Mascota.add(nom_Mascota);

			nom_Mascota.setText(actual.getDni_Mascota());

			if(control_Cita.getNumCitas()>0) {
				JButton btnVercitas = new JButton("Ver cita");
				btnVercitas.addActionListener(new VerCitas(winUser, cliente, actual));
				btnVercitas.setBounds(633, 7, 89, 23);
				panel_Mascota.add(btnVercitas);
			}

			winUser.setPanelMascota(panel_Mascota);
			pos=pos+41;
		}



		if(winUser.eliminar_Masc!=null&&winUser.aniadir_Masc!=null) {

			winUser.eliminar_Usuario.addActionListener(new DropUser(winUser,cliente));
			winUser.eliminar_Usuario.setBounds(29, 448, 178, 30);
			winUser.frame.getContentPane().add(winUser.eliminar_Usuario);

			winUser.aniadir_Masc.addActionListener(new AddMascota(cliente));
			winUser.aniadir_Masc.setBounds(677, 133, 46, 39);
			winUser.frame.getContentPane().add(winUser.aniadir_Masc);

			winUser.eliminar_Masc.addActionListener(new DropMascota(winUser,cliente,pos_Mascota));
			winUser.eliminar_Masc.setBounds(741, 133, 46, 39);
			winUser.frame.getContentPane().add(winUser.eliminar_Masc);
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cita nueva=new Cita(null);
					ControlCita cCita=new ControlCita(nueva,cliente.getMascota(pos_Mascota));
					nueva.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
					nueva.frame.getContentPane().setBackground(Color.WHITE);
					nueva.frame.setVisible(true);			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}

class Catalogo implements ActionListener {

	public Cliente winUser;
	public Usuario cliente;

	public Catalogo(Cliente winUser, Usuario cliente) {
		// TODO Auto-generated constructor stub
		this.winUser=winUser;
		this.cliente=cliente;
	}

	public void actionPerformed(ActionEvent e) {

		Reserva admin_Productos=new Reserva(null,null);
		ControlReserva conReserva=new ControlReserva(cliente,admin_Productos);
		admin_Productos.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		admin_Productos.frame.setVisible(true);

	}

}

class VerCitas implements ActionListener {

	public Cliente winUser;
	public Usuario cliente;
	public Mascota actual;

	public VerCitas(Cliente winUser, Usuario cliente, Mascota actual) {
		// TODO Auto-generated constructor stub
		this.winUser=winUser;
		this.cliente=cliente;
		this.actual=actual;
	}

	public void actionPerformed(ActionEvent arg0) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista.Mascota ventana_Mascota = new vista.Mascota(actual);
					ControlMascota cMasc=new ControlMascota(ventana_Mascota,actual);
					ventana_Mascota.frame.setVisible(true);
					ventana_Mascota.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		

	}

}

class DropUser implements ActionListener {

	public Cliente winUser;
	public Usuario cliente;

	public DropUser(Cliente winUser, Usuario cliente) {
		// TODO Auto-generated constructor stub
		this.winUser=winUser;
		this.cliente=cliente;
	}

	public void actionPerformed(ActionEvent e) {

		cliente.eliminar_Usuario(cliente.getDni_usuario());
		winUser.frame.setVisible(false);

	}

}

class AddMascota implements ActionListener {

	public Usuario cliente;

	public AddMascota(Usuario cliente) {
		this.cliente=cliente;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aniadirmascota nueva_Mascota=new Aniadirmascota();
					ControlAddMasc cAdMas=new ControlAddMasc(nueva_Mascota,cliente.getDni_usuario());
					nueva_Mascota.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
					nueva_Mascota.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		

	}

}

class Salir implements ActionListener {

	public Cliente winUser;

	public Salir(Cliente winUser) {
		// TODO Auto-generated constructor stub
		this.winUser=winUser;
	}

	public void actionPerformed(ActionEvent e) {

		winUser.frame.setVisible(false);

	}

}

class DropMascota implements ActionListener {

	public Cliente winUser;
	public Usuario cliente;
	public int pos_mascota;

	public DropMascota(Cliente winUser2, Usuario cliente, int pos_Mascota) {
		// TODO Auto-generated constructor stub
		this.winUser=winUser;
		this.cliente=cliente;
		this.pos_mascota=pos_Mascota;
	}

	public void actionPerformed(ActionEvent e) {

		winUser.mascota_Control.eliminar_Mascota(cliente.getMascota(pos_mascota).getDni_Mascota());

	}

}

class Capturador extends MouseAdapter{

	public Cliente winUser;

	public Capturador(Cliente winUser) {
		// TODO Auto-generated constructor stub
		this.winUser=winUser;
	}

	public void mousePressed(MouseEvent arg0) {

		winUser.frame.getContentPane().add(winUser.btnPedirCita);

		int pos=winUser.panel_Mascota.getY();

		if(pos!=0) {
			winUser.pos_Mascota=(pos+1)%41;
		}
		else {
			winUser.pos_Mascota=pos%10;
		}

		winUser.frame.repaint();

	}
}