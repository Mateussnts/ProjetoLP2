package Item;

public class Item {
	
	private String id;
	private String descricaoItem;
	private int quantidade;
	private String tag;
	
	public Item(String id, String descricaoItem, int quantidade, String tag) {
		this.id = id;
		this.descricaoItem = descricaoItem;
		this.quantidade = quantidade;
		this.tag = tag;
		
	}
	
	public String toString() {
		return this.id + " - " + this.descricaoItem + ", " + "tags:" + "[" + this.tag + "], " + "quantidade: " + this.quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoItem == null) ? 0 : descricaoItem.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	

}
