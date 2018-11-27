package Sistema;

import java.io.IOException;

import Controladores.Controller;
import easyaccept.EasyAccept;

public class Facade {
	private Controller control;
	

	public static void main(String[] args) {
		args = new String[] {"Sistema.Facade", "EasyAccept/use_case_1.txt"
				+ "EasyAccept/use_case_2.txt"};
		EasyAccept.main(args);
		
	}
	
	public Facade() {
		this.control = new Controller();
	}
	
	public void lerReceptores(String caminho) throws IOException {
		this.control.lerReceptores(caminho);
	}
	
	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		return this.Control.adicionaDoador(id, nome, email, celular, classe);
	}

	public String pesquisaUsuarioPorId(String id) {
		return this.Control.pesquisaUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) {
		return this.Control.pesquisaUsuarioPorNome(nome);
	}
	
	public String atualizaUsuario(String id, String nome, String email, String celular) {
		return this.Control.atualizaUsuario(id, nome, email, celular);
	}
	
	public void removeUsuario(String id) {
		this.Control.removeUsuario(id);
	}
	
	public void adicionaDescritor(String descricao) {
		this.Control.adicionaDescritor(descricao);
	}

}
