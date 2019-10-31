package entidades;

import java.io.Serializable;

/**
 * representacao do item que sera criado pelo sistema e associado a um usuario.
 *
 */

public class Item implements Comparable<Item>, Serializable {

	private static final long serialVersionUID = 1L;
	private String idDoador;
	private String descricaoItem;
	private String tags;
	private int idItem;
	public int quantidade;
	private int pontos;

	/**
	 * Metodo construtor do item que sera armazenado.
	 * 
	 * @param idDoador      numero de identificacao do usuario.
	 * @param descricaoItem descricao do item que sera criado.
	 * @param quantidade    descricao em inteiro da quantidade de itens especificos.
	 * @param tags          tag referente a informacoes do item.
	 * @param idItem        numero de identificacao em inteiro do item criado.
	 */

	public Item(String idDoador, String descricaoItem, int quantidade, String tags, int idItem) {
		if (descricaoItem == null || descricaoItem.equals(""))
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");

		if (idDoador == null || idDoador.equals(""))
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");

		if (quantidade <= 0)
			throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");

		this.idDoador = idDoador;
		this.descricaoItem = descricaoItem;
		this.quantidade = quantidade;
		this.tags = tags;
		this.idItem = idItem;
	}

	/**
	 * Metodos acessadores do item.
	 */

	public int getIdItem() {
		return idItem;
	}

	public String getTags() {
		return tags;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getIdDoador() {
		return idDoador;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	/**
	 * Metodos modificadores dos itens.
	 */

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * Metodo para retornar a representacao da quantidade e da descricao do item
	 * para o metdodo de listagem de descricao.
	 * 
	 * @return retorna a quantidade e a descricao do item.
	 */

	public String listaItens() {
		return this.getQuantidade() + " - " + this.getDescricaoItem();
	}

	/**
	 * Representacao textual do item com suas informacoes.
	 */

	@Override
	public String toString() {
		return idItem + " - " + descricaoItem + ", " + "tags: [" + separador() + "], quantidade: " + quantidade;
	}

	/**
	 * Metodo responsavel por separar o array de tags dos itens.
	 * 
	 * @return retorna a tag separada e concatenada ao sistema.
	 */

	private String separador() {
		String[] tagsSplited = tags.split(",");
		String saida = "";
		for (int i = 0; i < tagsSplited.length; i++) {
			if (i == tagsSplited.length - 1) {
				saida += tagsSplited[i];
			} else {
				saida += tagsSplited[i] + ", ";
			}
		}
		return saida;
	}

	@Override
	public int compareTo(Item outroItem) {
		if (this.getQuantidade() > outroItem.getQuantidade()) {
			return -1;
		}
		if (this.getQuantidade() < outroItem.getQuantidade()) {
			return 1;
		}

		return this.getDescricaoItem().compareTo(outroItem.getDescricaoItem());
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoItem == null) ? 0 : descricaoItem.hashCode());
		result = prime * result + ((idDoador == null) ? 0 : idDoador.hashCode());
		result = prime * result + idItem;
		result = prime * result + pontos;
		result = prime * result + quantidade;
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		Item other = (Item) obj;
		if (descricaoItem == null) {
			if (other.descricaoItem != null)
				return false;
		} else if (!descricaoItem.equals(other.descricaoItem))
			return false;
		if (idDoador == null) {
			if (other.idDoador != null)
				return false;
		} else if (!idDoador.equals(other.idDoador))
			return false;
		if (idItem != other.idItem)
			return false;
		if (pontos != other.pontos)
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

}