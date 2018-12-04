package Interfaces;

import Item.Item;

public class ItensComparable implements Comparable<Item> {
	private int quantidade;
	
	public int compareTo(Item outroItem) {
		
		if (this.quantidade < outroItem.quantidade) {
            return -1;
        }
        if (this.quantidade > outroItem.quantidade) {
            return 1;
        }
 
		return 0;
	}

}