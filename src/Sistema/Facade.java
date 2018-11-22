package Sistema;

import Controladores.ControllerUsuario;
import easyaccept.EasyAccept;

public class Facade {
	private ControllerUsuario usuarioControl;

	public static void main(String[] args) {
		args = new String[] { "Sistema.Facade", "EasyAccept/use_case_1.txt"};
		
		EasyAccept.main(args);
	}
	
	public Facade() {
		this.usuarioControl = new ControllerUsuario();
	}
	
	public void adicionaDoador(String id, String nome, String email, String celular, String classe) {
		this.usuarioControl.adicionaDoador(id, nome, email, celular, classe);
	}

	public String pesquisaUsuarioPorId(String id) {
		return this.usuarioControl.pesquisaUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) {
		return this.usuarioControl.pesquisaUsuarioPorNome(nome);
	}
	
	public void atualizaUsuario(String id, String parametro, String novoParametro) {
		this.usuarioControl.atualizaUsuario(id, parametro, novoParametro);
	}
	
	public void removeUsuario(String id) {
		this.usuarioControl.removeUsuario(id);
	}

}
