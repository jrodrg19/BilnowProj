package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import modelo.Mascota;
import vista.Cita;

public class ControlMascota extends WindowAdapter{
	
	private Mascota mascota;
	
	private vista.Mascota winMascota;
	
	private modelo.Cita control_Cita;
	
	private int cita_Seleccionada;

	public ControlMascota(vista.Mascota ventana_Mascota, Mascota actual) {
		// TODO Auto-generated constructor stub
		
		this.winMascota=ventana_Mascota;
		this.mascota=actual;
		control_Cita=new modelo.Cita(actual.getDni_Mascota());
		winMascota.frame.addWindowListener(this);
		
	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
		winMascota.btnBorrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				control_Cita.eliminarCita(cita_Seleccionada);
				
				pintar_Panel();
									
			}
		});
		
		winMascota.btnEditarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Cita nueva=new Cita(null);
							control_Cita.eliminarCita(cita_Seleccionada);
							ControlCita cCita=new ControlCita(nueva,mascota);
							nueva.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
							nueva.frame.getContentPane().setBackground(Color.WHITE);
							nueva.frame.setVisible(true);			
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
			}
		});
		
		pintar_Panel();

	}
	
	private void pintar_Panel() {
		
		JPanel panel = new JPanel();
		winMascota.scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		panel.setPreferredSize(new Dimension(426, 43*control_Cita.getNumCitas()));
		
		control_Cita.getCitasMascota();

		int pos=0;
		
		for(int i=0;i< control_Cita.getNumCitas();i++) {
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, pos, 426, 43);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel label_Fecha = new JLabel(control_Cita.getCita(i));
			label_Fecha.setBounds(50, 11, 300, 14);
			panel_1.add(label_Fecha);
			
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					winMascota.frame.getContentPane().add(winMascota.btnBorrarCita);
					
					winMascota.frame.getContentPane().add(winMascota.btnEditarCita);

					
					int pos=panel_1.getY();
					
					if(pos!=0) {
						cita_Seleccionada=pos/43;
					}
					else {
						cita_Seleccionada=0;
					}
					
					winMascota.frame.repaint();
					
				}
			});
			
			pos=pos+43;
			
		}
	
	}
	
}
