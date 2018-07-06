package controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.WindowConstants;

import modelo.AccesoBD;
import modelo.Usuario;
import vista.Administrador;
import vista.Aniadircliente;
import vista.Cliente;
import vista.Reserva;

public class ControlAdmin implements ActionListener{

	private Administrador winAdmin;

	public ControlAdmin(Administrador nA) {
		// TODO Auto-generated constructor stub

		this.winAdmin=nA;
		winAdmin.btnAadirCliente.addActionListener(this);
		winAdmin.btnBuscar.addActionListener(new Buscar(winAdmin));
		winAdmin.mntmAadirCliente.addActionListener(this);
		winAdmin.btnAniadirProducto.addActionListener(new AddProducto(winAdmin));
		winAdmin.mntmAadirProducto.addActionListener(new AddProducto(winAdmin));
		winAdmin.mntmSalir.addActionListener(new ExitAd(winAdmin));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Aniadircliente nuevo=new Aniadircliente();
		ControlAddUser cNu=new ControlAddUser(nuevo);
		nuevo.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		nuevo.frame.setVisible(true);
		
	}

}

class AddProducto implements ActionListener{
	
	public Administrador wiAdmin;
	
	public AddProducto(Administrador winAdmin) {
		// TODO Auto-generated constructor stub
		this.wiAdmin=winAdmin;
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton aniadir= new JButton("+");
		JButton eliminar=new JButton("-");
		
		Reserva admin_Productos=new Reserva(aniadir,eliminar);
		ControlReserva conReserva=new ControlReserva(null,admin_Productos);
		admin_Productos.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		admin_Productos.frame.setVisible(true);
		
	}
	
}

class Buscar implements ActionListener{
	
	public Administrador wiAdmin;

	public Buscar(Administrador winAdmin) {
		// TODO Auto-generated constructor stub
		this.wiAdmin=winAdmin;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		String usuario=wiAdmin.textField.getText();
		boolean existe=false;
		AccesoBD consulta=new AccesoBD();
		existe=consulta.existeUserBD(usuario);
		if(existe==true) {
			
			JButton btnagregarButton = new JButton("+");
			JButton buttoneliminar = new JButton("-");
			JButton eliminarUser = new JButton("Eliminar usuario");
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Cliente cliente_Edita=new Cliente(btnagregarButton,buttoneliminar,eliminarUser);
						ControlUser cUser=new ControlUser(new Usuario(usuario),cliente_Edita); 
						cliente_Edita.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
						cliente_Edita.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		else {
			Aniadircliente nuevo=new Aniadircliente();
			ControlAddUser cNu=new ControlAddUser(nuevo);
			nuevo.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			nuevo.frame.setVisible(true);
		}
		
		
	}
	
}

class ExitAd implements ActionListener {

	public Administrador winUser;

	public ExitAd(Administrador winAdmin) {
		// TODO Auto-generated constructor stub
		this.winUser=winAdmin;
	}

	public void actionPerformed(ActionEvent e) {

		winUser.frame.setVisible(false);

	}

}