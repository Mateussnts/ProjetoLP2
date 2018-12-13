package interfaces;

import java.util.Comparator;

import entidades.Item;

public class ItensComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getDescricaoItem().
                compareTo(o2.getDescricaoItem());
	}

}
