package Facade;

import Controladores.ControllerUsuario;
import easyaccept.EasyAccept;

public class Facade {
	private ControllerUsuario usuarioControl;

	public static void main(String[] args) {
		args = new String[] { "Facade", "EasyAccept/use_case_1.txt"};
		
		EasyAccept.main(args);
	}
	
	public Facade() {
		this.usuarioControl = new ControllerUsuario();
	}
	
	public void adicionaDoador(String id, String nome, String email, String celular, String classe) {
		this.usuarioControl.adicionaDoador(id, nome, email, celular, classe);
	}
}
