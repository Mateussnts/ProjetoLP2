package ItemTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Item.Item;

class ItemTest {
	
	public class TestItem{
		
		private Item item;

		//@Test(expected=NullPointerException.class)
		public void testDescricaoNula() {
			
			item = new Item("12345678901", null, 1, "azul, vermelho", 0);
		}
		
		//@Test(expected=NullPointerException.class)
		public void testDescricaovazia() {
			
			item = new Item("12345678901", "", 1, "azul, vermelho", 0);
			
		}
		
		//@Test(expected=NullPointerException.class)
		public void testIdDoadornulo() {
			
			item = new Item(null, "casaco", 1, "azul, vermelho", 0);
			
		}
		
		//@Test(expected=NullPointerException.class)
		public void testIdDoadorvazia() {
			
			item = new Item("", "casaco", 1, "azul, vermelho", 0);
			
		}
		
		//@Test(expected=NullPointerException.class)
		public void testQuantidadeMenorQueZero() {
			
			item = new Item("12345678901", "casaco", -1, "azul, vermelho", 0);
			
		}
		
		@Test
		public void testToString() {
			
			item = new Item("12345678901", "", 1, "azul, vermelho", 0);
			assertEquals("0 - casaco, azul, vermelho, quantidade: 1", item.toString());
			
		}
	}
}
