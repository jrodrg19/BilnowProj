package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AccesoBD;
import vista.Aniadirmascota;

public class ControlAddMasc implements ActionListener {
	
	private Aniadirmascota winAddMasc;
	private String dni;

	public ControlAddMasc(Aniadirmascota nueva_Mascota, String dni_usuario) {
		// TODO Auto-generated constructor stub
		
		this.winAddMasc=nueva_Mascota;
		this.dni=dni_usuario;
		
		winAddMasc.textDNIDuenio.setText(dni);
		winAddMasc.btnAniadir.addActionListener(this);
		winAddMasc.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			winAddMasc.frame.setVisible(false);
			
			}
		});
		
		winAddMasc.btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id_Mascota=winAddMasc.textFieldDNIMascota.getText();
				
				AccesoBD consulta=new AccesoBD();
				
				if(consulta.existeMascotaBD(id_Mascota)) {
					winAddMasc.textFieldDNIMascota.setBackground(Color.RED);
				}
				else {
					winAddMasc.textFieldDNIMascota.setBackground(Color.GREEN);
				}
			}
		});
		
	}

	public void actionPerformed(ActionEvent e) {
		
		boolean existe=false;
		AccesoBD consulta=new AccesoBD();
		existe=consulta.existeMascotaBD(winAddMasc.textFieldDNIMascota.getText());
		if(existe==true) {
			
			JOptionPane.showMessageDialog(winAddMasc.btnAniadir, "Mascota ya registrada en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		else {

			consulta=new AccesoBD();
			
			int sexo=0;
			
			if(winAddMasc.chckbxMacho.isSelected()) {
				sexo=1;
			}
			
			winAddMasc.mascota.aniadir_Mascota(winAddMasc.textFieldDNIMascota.getText(),winAddMasc.textNombre.getText(),winAddMasc.textEspecie.getText(),
					winAddMasc.textRaza.getText(),winAddMasc.textCapa.getText(),winAddMasc.elegir_Fecha.getDate(),
					sexo,winAddMasc.textDNIDuenio.getText());
		
			winAddMasc.frame.setVisible(false);
			
		}
		
	}
	
}
