package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Mascota;
import vista.Cita;

public class ControlCita extends WindowAdapter {

	private modelo.Mascota mascota;
	private Cita winCita;
	private final String[] horarios= {"8:00",
			"9:00",
			"10:00",
			"11:00",
			"12:00",
			"13:00",
			"16:00",
			"17:00",
			"18:00",
			"19:00",
	"20:00"};
	private Date cita_Fecha;
	private modelo.Cita control_cita;
	private int hora_Seleccionada;

	public ControlCita(Cita nueva, Mascota mascota) {
		// TODO Auto-generated constructor stub
		this.winCita=nueva;
		this.mascota=mascota;
		this.winCita.frame.addWindowListener(this);
	}

	public void windowOpened(WindowEvent e) {
		cita_Fecha=new Date();
		winCita.calendario.getDayChooser().addPropertyChangeListener(
				new java.beans.PropertyChangeListener() {

					@Override
					public void propertyChange(java.beans.PropertyChangeEvent evt) {
						if (evt.getPropertyName().compareTo("day") == 0) {

							cita_Fecha=winCita.calendario.getDate();
							pintar_Horas();
						}
					}
				});

		winCita.panel__Horas.setPreferredSize(new Dimension(418,horarios.length*31));

		winCita.btnGuardarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control_cita=new modelo.Cita(mascota.getDni_Mascota());
				
				String hora= horarios[hora_Seleccionada];
				
				int fecha = winCita.calendario.getCalendar().get(java.util.Calendar.DATE);
				
				cita_Fecha.setDate(fecha);
							
				//variables para la consulta prepararlas
				
				control_cita.aniadirCita(cita_Fecha,hora);
					
				winCita.frame.setVisible(false);
			}
		});

	}

	public void pintar_Horas() {
		int pos_Lab=0;
		boolean hora_Libre=true;
		for (int i = 0; i < horarios.length; i++) {
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, pos_Lab, 418, 31);
			winCita.panel__Horas.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel_1 = new JLabel(horarios[i]);
			lblNewLabel_1.setBounds(27, 11, 46, 14);
			panel_1.add(lblNewLabel_1);

			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {

					int pos=panel_1.getY();

					if(pos!=0) {
						hora_Seleccionada=pos/31;
					}
					else {
						hora_Seleccionada=0;
					}

				}

			});

			modelo.Cita control2=new modelo.Cita(null);
			hora_Libre=control2.estaLibre(horarios[i],cita_Fecha);
			if(hora_Libre==true) {
				panel_1.setBackground(Color.GREEN);
			}
			else {
				panel_1.setBackground(Color.RED);
			}

			pos_Lab+=31;
		}
	}

}
