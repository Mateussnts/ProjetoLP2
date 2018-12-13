package entidades;

import java.util.ArrayList;

import controladores.ControllerItem;

/**
 * representacao de criacao de um usuario especifico.
 * tendo como atributos nome, email, celular, classe e id e um array que armazena os itens do usuario.
 * 
 */

public class Usuario {
	private String nome;
	private String email;
	private String celular;
	private String classe;
	private String id;
	private String status;
	
	private ArrayList<Item> itens;
	
	/**
	 * Metodo construtor do usuario.
	 * @param nome
	 * 		representacao em string do nome do usuario.
	 * @param email
	 * 		representacao em string do email do usuario.
	 * @param celular
	 * 		representacao em string do celular do usuario.
	 * @param classe
	 * 		representacao em string da classe do usuario.
	 * @param id
	 * 		representacao em string do id do ususario.
	 * @param status 
	 */
	
	public Usuario(String id, String nome, String email, String celular, String classe, String status) {
		
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");
		}
		
		if(email == null || email.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: email nao pode ser vazio ou nulo.");
		}
		
		if(celular == null || celular.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: celular nao pode ser vazio ou nulo.");
		}
		
		if(classe == null || classe.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: classe nao pode ser vazia ou nula.");
		}
		
		if(id == null || id.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}
		
		if(!classe.equals("PESSOA_FISICA") && !classe.equals("IGREJA") && !classe.equals("ONG")
			&& !classe.equals("ORGAO_PUBLICO_ESTADUAL") && !classe.equals("ASSOCIACAO") && !classe.equals("SOCIEDADE") && !classe.equals("ORGAO_PUBLICO_MUNICIPAL")) {
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
		
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.classe = classe;
		this.id = id;
		this.status = status;
		this.itens = new ArrayList<>();
	}

	/**
	 * Metodo que retorna a representacao textual do usuario
	 * tendo como parametros os atributos do usuario.
	 */
	
	@Override
	public String toString() {
		return nome + "/" + id + ", " + email + ", " + celular + ", " + "status: " + status;
	}
	
	/**
	 * Metodos acessadores dos atributos do usuario.
	 */
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}

	public String getCelular() {
		return celular;
	}
	
	public String getclasse() {
		return classe;
	}
	
	public String getid() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public ArrayList<Item> getItens(){
		return this.itens;
	}
	
	/**
	 * Metodos modificadores dos atributos do usuario.
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setclasse(String classe) {
		this.classe = classe;
	}

	public void setid(String id) {
		this.id = id;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Metodo responsavel pelo cadastro de itens associado a um usuario do sistema e gerador do numero de
	 * identificacao do item.
	 * @param descricaoItem
	 * 		representacao da descricao do item que sera addicionado.
	 * @param quantidade
	 * 		representacao da quantidade de itens que sera adicionado.
	 * @param tags
	 * 		representacao da tag do item que sera adicionado.
	 * @return
	 * 		retorna o numero de identificacao do item que foi gerado no seu respectivo cadastro.
	 */
	
	public int adicionaItem(String descricaoItem, int quantidade, String tags) {
		Item item = buscarItem(descricaoItem);
		int idItem = ControllerItem.idItem;
		if (item == null) {
			item = new Item(this.id, descricaoItem.toLowerCase(), quantidade, tags,idItem);
			itens.add(item);
			ControllerItem.itens.add(item);
			ControllerItem.idItem ++;
			ControllerItem.adicionarDescricao(descricaoItem);
			return idItem;
		} else {
			itens.remove(item);
			ControllerItem.adicionarDescricao(descricaoItem);
			ControllerItem.itens.remove(item);
			item = new Item(this.id, descricaoItem.toLowerCase(), quantidade, tags,item.getIdItem());
			itens.add(item);
			ControllerItem.itens.add(item);
			return idItem;
		}
	}
	
	/**
	 * Metodo responsavel pela exibicao do item que esta associado a um usuario doador.
	 * buscar um usuario especifico e respectivamente seu item.
	 * @param id
	 * 		representacaco do numero de identificacao do item.
	 * @return
	 * 		retorna o item com sua devida representacao textual.
	 */
	
	public String exibirItem(int id) {
		String saida = "";
		Item item = buscarItem(id);
		if(item == null) {
			throw new IllegalArgumentException("Item nao encontrado: " + id + ".");
		}	
		else {
			saida = item.toString();
		}
		return saida;
	}
	
	/**
	 * Metodo de atualizacao de atributos do item que esta armazenado no sistema.
	 * utiliza o metodo de procura de item pelo seu numero de identificacao
	 * e recebe parametros que serao utilizados para atualizar os atributos do item.
	 * @param id
	 * 		representacao do numero de identificacao do item que sera buscado.
	 * @param quantidade
	 * 		representacao do atributo do item que sera modificado.
	 * @param tags
	 * 		representacao do atributo do item que sera modificado.
	 * @return
	 * 		retorna o item com seus atributos atualizados e o armazena novamente.
	 */
	
	public String atualizaItem(int id, int quantidade, String tags) {
		Item item = buscarItem(id);
		if(item == null) {
			throw new IllegalArgumentException("Item nao encontrado: " + id + ".");
		}
		if(!(tags == null || tags.equals(""))) 
			item.setTags(tags);
		
		if(!(quantidade == 0)) 
			item.setQuantidade(quantidade);
		
		ControllerItem.itens.remove(item);
		ControllerItem.itens.add(item);
		itens.remove(item);
		itens.add(item);
		return item.toString();
	}
	
	/**
	 * Metodo de remocao de item que esta associado a um usuario
	 * buscar o item que esta armazenado no arraylist referente ao numero de identificacao passado
	 * e o remove.
	 * @param id
	 * 		representacao do numero de identificacao do item que sera removido.
	 * @throws IllegalAccessException
	 */
	
	public void removeItem(int id) throws IllegalAccessException  {
		if(itens.size() == 0) 
			throw new IllegalAccessException("O Usuario nao possui itens cadastrados.");
		
		Item item = buscarItem(id);
		
		if(item == null) 
			throw new IllegalAccessException("Item nao encontrado: " + id + ".");
		
		itens.remove(item);
		ControllerItem.itens.remove(item);
	}
		
	/**
	 * Metodo de busca e itens cadastrados. Percorre o array de itens dos usuarios e retorna o item
	 * associado ao numero de identificacao passado.
	 * @param id
	 * 		representacao do numero de identificacao do item que sera procurado.
	 * @return
	 */
	
	private Item buscarItem(int id) {
		Item item = null;
		for (int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getIdItem() == id) {
				item = itens.get(i);
			}
		}
		return item;
	}
	
	/**
	 * "Metodo em Excecao". Utilizacao de polimorfismo para buscar um item cadastrado a um usuario
	 * a partir da sua string de representacao referente a descricao do item.
	 * @param descricaoItem
	 * 		representacao da descricao do item que esta armazenado.
	 * @return
	 * 		retorna o item associado a descricao passado como parametro.
	 */
	
	private Item buscarItem(String descricaoItem) {
		Item item = null;
		for (int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getDescricaoItem().equals(descricaoItem)) {
				item = itens.get(i);
			}
		}
		return item;
	}
	
	
	/**
	 * Hashcode and equals.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}	

	