package interfaces;

import java.util.Comparator;

import entidades.Item;

public class PontosComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		
		if (o1.getPontos() > o2.getPontos()) {
            return -1;
        }
        if (o1.getPontos() < o2.getPontos()) {
            return 1;
        }
 
        return o1.getDescricaoItem().compareTo(o2.getDescricaoItem());
	}
	
}
