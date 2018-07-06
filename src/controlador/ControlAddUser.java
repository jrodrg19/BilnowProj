package controlador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import modelo.AccesoBD;
import modelo.Usuario;
import vista.Aniadircliente;
import vista.Cliente;

public class ControlAddUser implements ActionListener{

	public Aniadircliente winAddCli;
	
	public ControlAddUser(Aniadircliente nuevo) {
		// TODO Auto-generated constructor stub
	
		this.winAddCli=nuevo;
		winAddCli.btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id_Usuario=winAddCli.textDNI.getText();

				AccesoBD consulta=new AccesoBD();

				if(consulta.existeUserBD(id_Usuario)) {
					winAddCli.textDNI.setBackground(Color.RED);
				}
				else {
					winAddCli.textDNI.setBackground(Color.GREEN);
				}

			}
		});
	
		winAddCli.btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean existe=false;
				AccesoBD consulta=new AccesoBD();
				existe=consulta.existeUserBD(winAddCli.textDNI.getText());
				if(existe==true) {

					JOptionPane.showMessageDialog(winAddCli.btnAniadir, "Usuario ya registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else {

					int rol=1;

					if(winAddCli.checkBoxAdmin.isSelected()) {
						rol=0;
					}

					Usuario nuevo=new Usuario();
					nuevo.aniadir_Usuario(winAddCli.textDNI.getText(),winAddCli.textNombre.getText(),winAddCli.textApellido.getText(),
							winAddCli.textTelefono.getText(),winAddCli.textContrasenia.getText(),winAddCli.textCorreo.getText(),
							winAddCli.textDireccion.getText(),rol);

					JButton btnagregarButton = new JButton("+");
					JButton buttoneliminar = new JButton("-");
					JButton eliminarUser=new JButton("Borrar Usuario");

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Cliente cliente_Edita=new Cliente(btnagregarButton,buttoneliminar,eliminarUser);
								ControlUser cUser=new ControlUser(new Usuario(winAddCli.textDNI.getText()),cliente_Edita); 
								cliente_Edita.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
								cliente_Edita.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

					winAddCli.frame.setVisible(false);	

				}

			}
		});
		
		winAddCli.btnCancelar.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		winAddCli.frame.setVisible(false);
	}

}
