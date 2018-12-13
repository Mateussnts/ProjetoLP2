package controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Item;
import entidades.Usuario;
import interfaces.DescricaoComparator;
import interfaces.ItensComparator;

/**
 * Representacao da classe de controle das operacoes(CRUD) dos itens que serao cadastrados
 * e armazenado no sistema. Criacao de atributo estatico para que os usarios possam fazer operacoes 
 * ao numero de identicacao dos itens.
 */

public class ControllerItem {
	
	private ControllerUsuario userControl;
	private static ArrayList<String> descritores;
	public static int idItem;
	public static ArrayList<Item> itens;
	public  ArrayList<Item> itensNecessarios;
	Item item;
	
	public ControllerItem (ControllerUsuario controllerUsuario) {
		descritores = new ArrayList<String>();
		this.userControl = controllerUsuario;
		ControllerItem.itens = new ArrayList<Item>();
		itensNecessarios = new ArrayList<>();
	}
	
	/**
	 * Metodo para a adicao de descricao aos itens que serao cadastrados;
	 * @param descricao
	 * 		descricao dos itens que serao doados.
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
	 * 		descricao do item que sera adicionado aos descritores do sistema.
	 */
	
	public static void adicionarDescricao(String descricaoItem) {
		if(!descritores.contains(descricaoItem.toLowerCase())) {
			descritores.add(descricaoItem);
		}
	}
	
	/**
	 * Metodo de adicao de itens para doacao tendo como parametros a descricao do item, seu numero de 
	 * identificacao, quantidade e tags, acessa a classe usuario e armazena os itens a um usuario especifico.
	 * @param idDoador
	 * 		numero de identificacao do doador.
	 * @param descricaoItem
	 * 		descricao do item que serao doados.
	 * @param quantidade
	 * 		quantidade dos itens que serao doados.
	 * @param tags
	 * 		tags do item que sera doado.
	 * @return
	 * 		retorna o numero de identificacao do item.
	 */
	
	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		if(idDoador == null || idDoador.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(descricaoItem == null || descricaoItem.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");
		
		Usuario usuario = userControl.buscarUsuarioId(idDoador);
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");
		}

		return usuario.adicionaItem(descricaoItem, quantidade, tags);
	}

	/**
	 * Metodo de exibicao de itens cadastrados no sistema, acessa a classe de usuario que os itens estao
	 * armazenados e faz uma busca pelo usuario representado por seu ID, em seguida busca o item relacionado.
	 * @param id
	 * 		representacao do numero de identificacao do item.
	 * @param idDoador
	 * 		representacao do numero de identificacao do usuario doador.
	 * @return
	 * 		retorna a representacao textual de um item especifico que esta relacionado a um usuario especifico.
	 */
	
	public String exibeItem(int id, String idDoador) {
		Usuario usuario = userControl.buscarUsuarioId(idDoador);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");
		
		usuario.exibirItem(id);
		return usuario.exibirItem(id);
	}

	/**
	 * Metodo de atualizacao das informacoes do item(quantidade e tag), acessa a classe usuario e busca o item
	 * associado ao numero de identificacao do item e do usuario passado.
	 * @param id
	 * 		representacao em inteiro do numero de identificacao do item.
	 * @param idDoador
	 * 		representacao em str do numero de identificacao do doador.
	 * @param quantidade
	 * 		parametro que pode ser modificado no item.
	 * @param tags
	 * 		parametro que pode ser modificado no item.
	 * @return
	 * 		retorna o item atualizado.
	 */
	
	public String atualizaItemParaDoacao(int id, String idDoador, int quantidade, String tags) {
		if(id < 0) 
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		if(idDoador == null || idDoador.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		Usuario usuario = userControl.buscarUsuarioId(idDoador);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");

		return usuario.atualizaItem(id, quantidade, tags);
	}

	/**
	 * Metodo de remocao de itens que estao armazenados no sistema, acessa os usuarios e os istens que
	 * estao associados a um usuario e o remove.
	 * @param id
	 * 		representacao do numero de identificacao do item que sera removido.
	 * @param idDoador
	 * 		representacao do numero de identificacao do doador que tera seu item removido.
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
		
		usuario.removeItem(id);
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
	 * Metodo para verificacao dos descritores.
	 * Verifica se existe algum item cadatsrado no sistema com a descricao dos descritores.
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

	/**
	 * Metodo de adicao de itens para receptores tendo como parametros a descricao do itens, quantidades e tags, 
	 * acessa a classe usuario e armazena os itens a um usuario especifico.
	 * @param id
	 * 		numero de identificacao do receptor.
	 * @param descricaoItem
	 * 		descricao do item.
	 * @param quantidadeid
	 * 		quantidade dos itens.
	 * @param tags
	 * 		tags do item.
	 * @return
	 * 		retorna o numero de identificacao do item.
	 */
	
	public int adicionaItemNecessario(String idReceptor, String descricaoItem, int quantidade, String tags) {
		
		if(descricaoItem == null || descricaoItem.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");
		
		if(quantidade < 0) 
			throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");
		
		if(idReceptor == null || idReceptor.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		ControllerItem.idItem++;
		Item item = new Item(idReceptor, descricaoItem.toLowerCase(), quantidade, tags,idItem);
		
		adicionaItemNecessarios(item);
		
		Usuario receptor = userControl.buscarUsuarioId(idReceptor);
		return receptor.adicionaItem(descricaoItem, quantidade, tags);
	}
	

	private void adicionaItemNecessarios(Item item) {
		for (int i = 0; i < itensNecessarios.size(); i++) {
			if(itensNecessarios.get(i).getTags().equals(item.getTags())) {
				itensNecessarios.get(i).setQuantidade(item.getQuantidade());
				itensNecessarios.get(i).setIdItem(item.getIdItem());
				return;
			}
		}
		itensNecessarios.add(item);
	}

	/**
	 * Metodo de listagem de itens cadastrados no sistema, acessa a classe de usuario que os itens estao
	 * armazenados e faz uma busca pelo usuario representado por seu ID, em seguida busca o item relacionado.
	 * @param id
	 * 		representacao do numero de identificacao do item.
	 * @param idReceptor
	 * 		representacao do numero de identificacao do usuario receptor.
	 * @return
	 * 		retorna a representacao textual de um item especifico que esta relacibado a um usuario especifico.
	 */
	
	public String listaItensNecessarios() {
				
		String todosOsItens = "";
		String idUsuario;
				
		for(int i = 0; i < itensNecessarios.size(); i++) {
					
			idUsuario = itensNecessarios.get(i).getIdDoador();
			Usuario receptor = userControl.buscarUsuarioId(idUsuario);
					
			todosOsItens += itensNecessarios.get(i).toString() + ", Receptor: " + receptor.getNome() + "/" + receptor.getid() + " | ";
		}
				
		return todosOsItens.substring(0, todosOsItens.length()-3);
	}
	
	/**
	 * Metodo de atualizacao das informacoes do item(quantidade e tag), acessa a classe usuario e busca o item
	 * associado ao numero de identificacao do item e do usuario passado.
	 * @param id
	 * 		representacao em inteiro do numero de identificacao do item.
	 * @param idReceptor
	 * 		representacao em str do numero de identificacao do Receptor.
	 * @param quantidade
	 * 		parametro que pode ser modificado no item.
	 * @param tags
	 * 		parametro que pode ser modificado no item.
	 * @return
	 * 		retorna o item atualizado.
	 * @throws IllegalArgumentException 
	 */
	
	public String atualizaItemNecessario(int id, String idReceptor, int quantidade, String tags) {
		if(id < 0) 
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		if(idReceptor == null || idReceptor.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(!buscarItemNecessario(id)) {
			throw new IllegalArgumentException("Item nao encontrado: " + id + ".");
		}
		
		Usuario usuario = userControl.buscarUsuarioId(idReceptor);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idReceptor + ".");	
		
		String saida = "";
		for (int i = 0; i < itensNecessarios.size(); i++) {
			Item item = itensNecessarios.get(i);
			if(item.getIdItem() == id) {
				if(quantidade > 0) {
					itensNecessarios.get(i).setQuantidade(quantidade);
				} 
				if(!(tags == null || tags.equals(""))) {
					itensNecessarios.get(i).setTags(tags);
				}
				saida += itensNecessarios.get(i).toString();
			}
		}
		return saida;
	}
	
	private boolean buscarItemNecessario(int id) {
		for (int i = 0; i < itensNecessarios.size(); i++) {
			if(itensNecessarios.get(i).getIdItem() == id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo de remocao de itens que estao armazenados no sistema, acessa os usuarios e os itens que
	 * estao associados a um usuario e o remove.
	 * @param id
	 * 		representacao do numero de identificacao do item que sera removido.
	 * @param idReceptor
	 * 		representacao do numero de identificaco do receptor que tera seu item removido.
	 * @throws IllegalAccessException
	 */
	
	public void removeItemNecessario(int idItemNecessario, String idReceptor) throws IllegalAccessException{
		if(idReceptor == null || idReceptor.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(idItemNecessario < 0) 
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		Usuario usuario = userControl.buscarUsuarioId(idReceptor);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idReceptor + ".");
		
		usuario.removeItem(idItemNecessario);
	}

	/**
	 * metodo de matches entre itens ....
	 * @param idReceptor
	 * @param idItemNecessario
	 * @return
	 */
	
	public String match(String idReceptor, int idItemNecessario) {
		if(idReceptor == null || idReceptor.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(idItemNecessario < 0) 
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
	
		Usuario usuario = userControl.buscarUsuarioId(idReceptor);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + idReceptor + ".");
		
		if(!usuario.getStatus().equals("receptor"))
			throw new IllegalArgumentException("O Usuario deve ser um receptor: " + idReceptor + ".");
		
		return null;
	}
	
}

