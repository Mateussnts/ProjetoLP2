package Interfaces;

import java.util.Comparator;

/**
 * Interface de ordenacao dos descritores a partir de sua String.
 */

public class DescricaoComparator implements Comparator<String>{

	/**
	 * Metodo de ordenacao por String.
	 * Split que separa o indice especifico da string que sera utilizada para a a ordenacao.
	 */
	
	@Override
	public int compare(String o1, String o2) {
		String[] item1 = o1.split(" - ");
		String[] item2 = o2.split(" - ");
		return item1[1].compareTo(item2[1]);
	}
}
