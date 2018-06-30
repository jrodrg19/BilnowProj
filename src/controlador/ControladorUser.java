package controlador;

import modelo.Usuario;
import vista.Cliente;

public class ControladorUser {

	private Usuario cliente;
	private Cliente winUser;	
	
	public ControladorUser(Usuario user, Cliente nC) {
		// TODO Auto-generated constructor stub

		this.winUser=nC;
		this.cliente=user;
	
	}

}
