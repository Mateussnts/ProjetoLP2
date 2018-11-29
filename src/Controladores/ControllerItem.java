package Controladores;

import java.util.ArrayList;
import Usuarios.Usuario;

/**
 * Representacao da classe de controle das operacoes(CRUD) dos itens que serao cadastrados
 * e armazenado no sistema. criacao de atributo estatico para que os usarios possa fazer operacoes 
 * ao numero de identicacao dos itens.
 */

public class ControllerItem {
	
	private ArrayList<String> descritores;
	public static int idItem;
	
	public ControllerItem () {
		descritores = new ArrayList<String>();
	}
	
	/**
	 * Metodo para adiciocao de descriçao a itens que serao cadastrados;
	 * @param descricao
	 * 		descriçao dos itens que sera doado.
	 */
	
	public void adicionaDescritor(String descricao) {
		
		if(descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");		
		
		if(descritores.contains(descricao.toLowerCase()))
			throw new IllegalArgumentException("Descritor de Item ja existente: " + descricao.toLowerCase() + ".");
		
		descritores.add(descricao);
	}
	
	/**
	 * Metodo de adicao de itens para doacao tendo como parametros a descricao do itens seu numero de 
	 * identificacao, quantidades e tags, acessa a classe usuario e armazena os itens a um usuario especifico.
	 * @param idDoador
	 * 		numero de identificacao do doador.
	 * @param descricaoItem
	 * 		descricao do item que sera doado.
	 * @param quantidade
	 * 		quantidade dos itens que sera doado.
	 * @param tags
	 * 		tags do item que sera doado.
	 * @return
	 * 		retorna o numero de identificacao do item.
	 */
	
	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		if(idDoador == null || idDoador.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		Usuario usuario = ControllerSistema.controllerUsuario.buscarUsuarioId(idDoador);
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");
		}

		return usuario.adicionaItemParaDoacao(descricaoItem, quantidade, tags);
	}

	/**
	 * Metodo de exibicao de itens cadastrados no sistema, acessa a classe de usuario que os itens estao
	 * armazenados e faz uma busca pelo usuario representado por seu ID, em seguida busca o item relacionado.
	 * @param id
	 * 		representacao do numero de identificacao do item.
	 * @param idDoador
	 * 		representacao do numero de identificacao do usuario doador.
	 * @return
	 * 		retorna a representaçao textual de um item especifico que esta relacibado a um usuario especifico.
	 */
	
	public String exibeItem(int id, String idDoador) {
		Usuario usuario = ControllerSistema.controllerUsuario.buscarUsuarioId(idDoador);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");
		
		usuario.exibirItem(id);
		return usuario.exibirItem(id);
	}

	/**
	 * Metodo de atualizacao das informacoes do item(quantidade e tag) acessa a classe usuario e busca o item
	 * associado ao numero de identificacao do item e do usuario passado.
	 * @param id
	 * 		represnetacao em inteiro do numero de identificacao do item.
	 * @param idDoador
	 * 		representacao em str do numero de identificacao do doador
	 * @param quantidade
	 * 		parametro que pode ser modificado no item.
	 * @param tags
	 * 		parametro que pode ser modificado no item.
	 * @return
	 * 		retorna o  item atualizado.
	 */
	
	public String atualizaItemParaDoacao(int id, String idDoador, int quantidade, String tags) {
		if(id < 0) 
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		if(idDoador == null || idDoador.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		Usuario usuario = ControllerSistema.controllerUsuario.buscarUsuarioId(idDoador);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");

		return usuario.atualizaItemParaDoacao(id, quantidade, tags);
	}

	/**
	 * Metodo de remorcao de itens que estao armazenados no sistema, acessa os usuarios e os istens que
	 * estao associados a um usuario e o remove.
	 * @param id
	 * 		representacao do numero de identificacao do item que sera removido
	 * @param idDoador
	 * 		representacao do numero de identificaco do doador que tera seu item removido.
	 * @throws IllegalAccessException
	 */
	
	public void removeItemParaDoacao(int id, String idDoador) throws IllegalAccessException {
		if(id < 0) 
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		if(idDoador == null || idDoador.equals(""))
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		Usuario usuario = ControllerSistema.controllerUsuario.buscarUsuarioId(idDoador);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");
		
		usuario.removeItemParaDoacao(id);
	}
}
