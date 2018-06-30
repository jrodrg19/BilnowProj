package controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import org.hibernate.service.spi.Manageable;

import modelo.Usuario;
import vista.Administrador;
import vista.Cliente;
import vista.MainWindow;

public class ControladorMainWin extends WindowAdapter{

	private MainWindow mainBilnow;

	public ControladorMainWin(MainWindow mainBilnow) {

		this.mainBilnow=mainBilnow;

	}
	
	public void WindowOpened(WindowEvent e) {
		
		this.mainBilnow.btnAcceder.addActionListener(new InicioSesion(mainBilnow));
	}

}

class InicioSesion implements ActionListener{

	private MainWindow mainBilnow;
	
	private int cont_error=0;
	
	public InicioSesion(MainWindow mainBilnow) {

		this.mainBilnow=mainBilnow;

	}
	
	@SuppressWarnings({ "static-access", "unused" })
	public void actionPerformed(ActionEvent e) {

		System.out.println("hola");
		//En esta parte del programa haremos la consulta en la base de datos , para ver si el dni que hemos intrducido es de un administrador o de un cliente.

		Usuario user_control=new Usuario();

		int control_error=user_control.comprobarUsuario(mainBilnow.campo_Usuario.getText(),mainBilnow.campo_Password.getText());

		System.out.println(mainBilnow.campo_Usuario.getText()+", "+mainBilnow.campo_Password.getText());

		if(control_error==0) {

			JOptionPane.showMessageDialog(mainBilnow.btnAcceder, "Usuario no registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);

		}
		else if(control_error==1) {
			cont_error+=1;
			if(cont_error==5) {
				System.exit(0);
			}
			int intentos=5-cont_error;
			JOptionPane.showMessageDialog(mainBilnow.btnAcceder, "Contraseña incorrecta numero de intentos:"+intentos+"", "Error", JOptionPane.ERROR_MESSAGE);

		}
		else if(control_error==2) {

			Usuario user=new Usuario(mainBilnow.campo_Usuario.getText());

			if(mainBilnow.campo_Usuario.getText().equals(user.getDni_usuario())){

				if(mainBilnow.campo_Password.getText().equals(user.getPw_usuario())){

					if(user.getRol_usuario()==0) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Administrador frame=new Administrador(user);
									ControladorAdmin cAdm=new ControladorAdmin(frame);
									frame.setVisible(true);
									frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					
					else {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Cliente nC=new vista.Cliente(user,null,null,null);
									ControladorUser cUser=new ControladorUser(user, nC); 
									nC.setVisible(true);
									nC.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});

					}

				}

			}

		}

	}
	
	
	
	
}
