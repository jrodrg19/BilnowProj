import java.awt.EventQueue;

import controlador.ControladorMainWin;
import vista.MainWindow;

public class MainBilnow {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					ControladorMainWin mainWin=new ControladorMainWin(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
