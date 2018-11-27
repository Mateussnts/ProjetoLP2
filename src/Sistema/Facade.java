package Sistema;

import java.io.IOException;

import Controladores.ControllerUsuario;
import easyaccept.EasyAccept;

public class Facade {
	private ControllerUsuario usuarioControl;

	public static void main(String[] args) {
		args = new String[] {"Sistema.Facade", "EasyAccept/use_case_1.txt"};
		EasyAccept.main(args);
		
	}
	
	public Facade() {
		this.usuarioControl = new ControllerUsuario();
	}
	
	public void lerReceptores(String caminho) throws IOException {
		this.usuarioControl.lerReceptores(caminho);
	}
	
	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		return this.usuarioControl.adicionaDoador(id, nome, email, celular, classe);
	}

	public String pesquisaUsuarioPorId(String id) {
		return this.usuarioControl.pesquisaUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) {
		return this.usuarioControl.pesquisaUsuarioPorNome(nome);
	}
	
	public String atualizaUsuario(String id, String nome, String email, String celular) {
		return this.usuarioControl.atualizaUsuario(id, nome, email, celular);
	}
	
	public void removeUsuario(String id) {
		this.usuarioControl.removeUsuario(id);
	}
}
