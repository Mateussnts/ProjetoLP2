package Controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Interfaces.DescricaoComparator;
import Interfaces.ItensComparator;
import Item.Item;
import Usuarios.Usuario;

/**
 * Representacao da classe de controle das operacoes(CRUD) dos itens que serao cadastrados
 * e armazenado no sistema. criacao de atributo estatico para que os usarios possa fazer operacoes 
 * ao numero de identicacao dos itens.
 */

public class ControllerItem {
	
	private static ArrayList<String> descritores;
	public static int idItem;
	private ControllerUsuario userControl;
	public static ArrayList<Item> itens;
	
	public ControllerItem (ControllerUsuario controllerUsuario) {
		descritores = new ArrayList<String>();
		this.userControl = controllerUsuario;
		ControllerItem.itens = new ArrayList<Item>();
	}
	
	/**
	 * Metodo para adiciocao de descri�ao a itens que serao cadastrados;
	 * @param descricao
	 * 		descri�ao dos itens que sera doado.
	 */
	
	public void adicionaDescritor(String descricao) {
		
		if(descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");		
		
		if(descritores.contains(descricao.toLowerCase()))
			throw new IllegalArgumentException("Descritor de Item ja existente: " + descricao.toLowerCase() + ".");
		
	
		descritores.add(descricao.toLowerCase());
	}
	
	/**
	 * Metodo para adicionar descricao de itens que foram adicionados na criacao dos itens.
	 * @param descricaoItem
	 * 		descricao do item que sera a dicionado aos descritores do sistema.
	 */
	
	public static void adicionarDescricao(String descricaoItem) {
		if(!descritores.contains(descricaoItem.toLowerCase())) {
			descritores.add(descricaoItem);
		}
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
		
		Usuario usuario = userControl.buscarUsuarioId(idDoador);
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
	 * 		retorna a representa�ao textual de um item especifico que esta relacibado a um usuario especifico.
	 */
	
	public String exibeItem(int id, String idDoador) {
		Usuario usuario = userControl.buscarUsuarioId(idDoador);
		
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
		
		Usuario usuario = userControl.buscarUsuarioId(idDoador);
		
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
		
		Usuario usuario = userControl.buscarUsuarioId(idDoador);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");
		
		usuario.removeItemParaDoacao(id);
	}

	/**
	 * Metodo para listagem de descritores ordenados pela sua descricao.
	 * @return
	 * 		retorna a descricao e quantidade de todos os itens que foram cadastrados no sistema.
	 */
	
	public String listaDescritorDeItensParaDoacao() {
		String saida = "";
		ArrayList<String> listaDescritores = VerificaDescritorEmItens();
		DescricaoComparator dc = new DescricaoComparator();
		Collections.sort(listaDescritores,dc);
		
		for (int i = 0; i < listaDescritores.size()-1; i++) {
			saida += listaDescritores.get(i) + " | ";
		}
		
		saida += listaDescritores.get(listaDescritores.size()-1);
		
		return saida;
	}

	/**
	 * Metodo para verificacao do descritores.
	 * Verifica se existe algum item cadatsrado no sistema com a descricao dos descritores
	 * @return
	 * 		retorna a lista dos descritores com todos os itens que passarao pelo sistema.
	 */
	
	private ArrayList<String> VerificaDescritorEmItens() {
		ArrayList<String> listaDescritores = new ArrayList<String>();
		boolean contemDescritor = false;
		
		for (int i = 0; i < descritores.size(); i++) {
			for (int j = 0; j < itens.size(); j++) {
				if(descritores.get(i).equals(itens.get(j).getDescricaoItem())) {
					listaDescritores.add(itens.get(j).listaItens());
					contemDescritor = true;
				}
			}
			if(contemDescritor == false) 
				listaDescritores.add("0 - " + descritores.get(i));
			
			contemDescritor = false;
		}
		return listaDescritores;
	}

	/**
	 * Metodo para listagem de itens com toda sua representacao que estao cadastrados no sistema.
	 * @return
	 * 		retorna todos os itens cadastrados no sistema.
	 */
	
	public String listaItensParaDoacao() {
		List<Usuario> usuarios = userControl.listaUsuario;
		List<Item> itensDoados = new ArrayList<>();
		
		for (int i = 0; i < itens.size(); i++) {
			Item itemPorIndice = itens.get(i);
			itensDoados.add(itemPorIndice);
		}
		
		Collections.sort(itensDoados);
		String saida = "";
		
		for (int i = 0; i < itensDoados.size(); i++) {
			for (int j = 0; j < usuarios.size(); j++) 
				if(itensDoados.get(i).getIdDoador().equals(usuarios.get(j).getid())) {
					saida += itensDoados.get(i).toString() + ", doador: " + usuarios.get(j).getNome() + "/" + usuarios.get(j).getid() + " | ";
			}
		}
		return saida.substring(0, saida.length()-3);
	}

	/**
	 * Metodo para pesquisa de itens a partir de um string de descricao.
	 * @param
	 * 		representacao da string que sera passada para procura dos itens semelhantes.
	 * @return
	 * 		Retorna todos os itens referente a string passada como Parametro.
	 */
	
	public String pesquisaItemParaDoacaoPorDescricao(String desc) {
		String itensDesc = "";
		ArrayList<Item> itensPorDesc = new ArrayList<>();
		
		if(desc == null || desc.equals(""))
			throw new IllegalArgumentException("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.");
		
		for (int i = 0; i < itens.size(); i++) {
			Item item = itens.get(i);
			if(item.getDescricaoItem().contains(desc)) 
				itensPorDesc.add(item);
		}
		
		Collections.sort(itensPorDesc, new ItensComparator());
		for (Item item : itensPorDesc) {
			itensDesc += item.toString() + " | ";
		}
		return itensDesc.substring(0, itensDesc.length()-3);
	}
}
