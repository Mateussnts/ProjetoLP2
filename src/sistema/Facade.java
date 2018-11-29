package sistema;

import java.io.IOException;

import Controladores.ControllerSistema;
import easyaccept.EasyAccept;

/**
 * Representacao da fachada de operacoes do sistema, recebe metodos da classe de controle geral.
 * responsavel por ler os devidos controllers das classes que necessitam de operaçoes.
 */

public class Facade {

	private ControllerSistema controller;
	
	public static void main(String[] args) {
		args = new String[] {"sistema.Facade", "EasyAccept/use_case_1.txt", "EasyAccept/use_case_2.txt"};
		EasyAccept.main(args);
	}
	
	public Facade() {
		this.controller = new ControllerSistema();
	}
	
	public void lerReceptores(String caminho) throws IOException {
		this.controller.lerReceptores(caminho);
	}
	
	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		return this.controller.adicionaDoador(id, nome, email, celular, classe);
	}

	public String pesquisaUsuarioPorId(String id) {
		return this.controller.pesquisaUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) {
		return this.controller.pesquisaUsuarioPorNome(nome);
	}
	
	public String atualizaUsuario(String id, String nome, String email, String celular) {
		return this.controller.atualizaUsuario(id, nome, email, celular);
	}
	
	public void removeUsuario(String id) {
		this.controller.removeUsuario(id);
	}

	public void adicionaDescritor(String descricao) {
		this.controller.adicionaDescritor(descricao);
	}

	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		return this.controller.adicionaItemParaDoacao(idDoador, descricaoItem, quantidade, tags);
	}
	
	public String exibeItem ( int id, String idDoador) {
		return this.controller.exibeItem(id,idDoador);
	}
	
	public String atualizaItemParaDoacao (int id,String idDoador, int quantidade, String tags){
		return this.controller.atualizaItemParaDoacao(id,idDoador,quantidade,tags);
	}
	
	public void removeItemParaDoacao(int id, String idDoador) throws IllegalAccessException {
		this.controller.removeItemParaDoacao(id,idDoador);
	}
}
