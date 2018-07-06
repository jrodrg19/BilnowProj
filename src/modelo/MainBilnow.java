package modelo;
import java.awt.EventQueue;

import controlador.*;
import vista.*;

public class MainBilnow {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.btnAcceder.addActionListener(new ControlMainWin(frame));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
