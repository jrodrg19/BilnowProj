package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.AccesoBD;
import vista.Aniadirproducto;

public class ControlAddProd implements ActionListener {

	private Aniadirproducto winAddProd;
	
	public ControlAddProd(Aniadirproducto addProd) {
		// TODO Auto-generated constructor stub
		
		this.winAddProd=addProd;
		winAddProd.btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				boolean existe=false;
				AccesoBD consulta=new AccesoBD();
				existe=consulta.existeProductoBD(winAddProd.textReferencia.getText());
				if(existe==true) {

					JOptionPane.showMessageDialog(winAddProd.btnAniadir, "Producto ya registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else {

					//consulta.aniadir_ProductoBD(textReferencia.getText(),textNombre.getText(),textFabricante.getText(),elegir_Fecha.getDate(),textPrecio.getText());

					winAddProd.frame.setVisible(false);

				}

			}
		});
		
		winAddProd.btnCancelar.addActionListener(this);
		
		winAddProd.btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id_Producto=winAddProd.textReferencia.getText();

				AccesoBD consulta=new AccesoBD();

				if(consulta.existeProductoBD(id_Producto)) {
					winAddProd.textReferencia.setBackground(Color.RED);
				}
				else {
					winAddProd.textReferencia.setBackground(Color.GREEN);
				}

			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		winAddProd.frame.setVisible(false);
	}


}
