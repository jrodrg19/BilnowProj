package controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import modelo.*;
import vista.*;

public class ControlMainWin implements ActionListener{

	private MainWindow mainBilnow;
	private int cont_error=0;

	public ControlMainWin(MainWindow mainBilnow) {

		this.mainBilnow=mainBilnow;
		this.mainBilnow.btnAcceder.addActionListener(this);

	}

	public void actionPerformed(ActionEvent arg0) {

		//En esta parte del programa haremos la consulta en la base de datos , para ver si el dni que hemos intrducido es de un administrador o de un cliente.

		Usuario user_control=new Usuario();

		int control_error=user_control.comprobarUsuario(mainBilnow.campo_Usuario.getText(),mainBilnow.campo_Password.getText());

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
									vista.Administrador aDwin=new vista.Administrador();
									ControlAdmin cAdm=new ControlAdmin(aDwin);
									aDwin.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
									aDwin.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else {

						Cliente nC=new vista.Cliente(null,null,null);
						ControlUser cUser=new ControlUser(user, nC); 
						nC.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
						nC.frame.setVisible(true);

					}

				}

			}

		}

	}


}
