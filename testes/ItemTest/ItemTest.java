package ItemTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import Item.Item;

class ItemTest {
	
	public class TestItem{
		
		private Item item;

		@Test
		public void testDescricaoNula()  {
			assertThrows(NullPointerException.class,
					() -> new Item("12345678901", null, 1, "azul, vermelho", 0));
		}
		
		@Test
		public void testDescricaovazia() {
			assertThrows(NullPointerException.class,
					() -> new Item("12345678901", "", 1, "azul, vermelho", 0));	
		}
		
		@Test
		public void testIdDoadornulo() {
			assertThrows(NullPointerException.class,
					() -> new Item(null,"casaco", 1, "azul, vermelho", 0));
		}
		
		@Test
		public void testIdDoadorvazia() {
			assertThrows(NullPointerException.class,
					() -> new Item("","casaco", 1, "azul, vermelho", 0));	
		}
		
		@Test
		public void testQuantidadeMenorQueZero() {
			assertThrows(NullPointerException.class,
					() -> new Item("12345678901","casaco", -1, "azul, vermelho", 0));	
		}
		
		@Test
		public void testToString() {
			
			item = new Item("12345678901", "", 1, "azul, vermelho", 0);
			assertEquals("0 - casaco, azul, vermelho, quantidade: 1", item.toString());
			
		}
	}
}
