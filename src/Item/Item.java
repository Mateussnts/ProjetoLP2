package Item;

public class Item {
	
	private String idDoador;
	private String descricaoItem;
	private int quantidade;
	private String tag;
	
	public Item(String idDoador, String descricaoItem, int quantidade, String tag) {
		this.idDoador = idDoador;
		this.descricaoItem = descricaoItem;
		this.quantidade = quantidade;
		this.tag = tag;
		
	}
	
	public String toString() {
		return this.idDoador + " - " + this.descricaoItem + ", " + "tags:" + "[" + this.tag + "], " + "quantidade: " + this.quantidade;
	}

}
