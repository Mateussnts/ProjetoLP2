package Controladores;

import java.io.IOException;

/**
 * representacao do controller geral de operacoes do sistema, responsavel por ler a classe
 * de controle dos usuarios e dos itens e ser chamado pela fachada com as respectivas operaçoes
 * do sistema completo. criacao de controller estatico para que o controller de itens possa ter acesso a lista
 * de usuario e assim aplicar a associacao de itens aos usuarios doadores.
 */

public class ControllerSistema {
	
	public static ControllerUsuario controllerUsuario;
	private ControllerItem controllerItem;
	
	public ControllerSistema() {
		controllerUsuario = new ControllerUsuario();
		controllerItem = new ControllerItem();
	}

	public void lerReceptores(String caminho) throws IOException {
		ControllerSistema.controllerUsuario.lerReceptores(caminho);
	}

	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		return controllerUsuario.adicionaDoador(id, nome, email, celular, classe);
	}

	public String pesquisaUsuarioPorId(String id) {
		return controllerUsuario.pesquisaUsuarioPorId(id);
	}

	public String pesquisaUsuarioPorNome(String nome) {
		return controllerUsuario.pesquisaUsuarioPorNome(nome);
	}

	public String atualizaUsuario(String id, String nome, String email, String celular) {
		return controllerUsuario.atualizaUsuario(id, nome, email, celular);
	}

	public void removeUsuario(String id) {
		ControllerSistema.controllerUsuario.removeUsuario(id);
	}

	public void adicionaDescritor(String descricao) {
		this.controllerItem.adicionaDescritor(descricao);
	}

	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		return controllerItem.adicionaItemParaDoacao(idDoador,descricaoItem,quantidade,tags);
	}

	public String exibeItem(int id, String idDoador) {
		return controllerItem.exibeItem(id,idDoador);
	}

	public String atualizaItemParaDoacao(int id, String idDoador, int quantidade, String tags) {
		return controllerItem.atualizaItemParaDoacao(id, idDoador, quantidade, tags);
	}

	public void removeItemParaDoacao(int id, String idDoador) throws IllegalAccessException {
		this.controllerItem.removeItemParaDoacao(id,idDoador);
	}

}
