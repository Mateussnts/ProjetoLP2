package controladoresTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import controladores.ControllerItem;

class ControllerItemTest {

	private ControllerItem ci;
	
	@Before
	public void testItemController() {
		
		this.ci = new ControllerItem(null);
	}
	
	@Test
	public void testadicionaItemParaDoacao() {
		
		assertEquals(1, this.ci.adicionaItemParaDoacao("12345678901", "casaco", 1, "azul, vermelho"));	
	}
	
	@Test
	public void testexibeItem() {
		
		assertEquals("1- casaco, azul, vermelho, quantidade: 1", ci.exibeItem(1,"12345678901"));	
	}
	
	@Test
	public void testatualizaItemParaDoacao() {
		
		assertEquals("1- casaco, azul, vermelho, quantidade: 2", ci.atualizaItemParaDoacao(1, "12345678901", 2,"azul, vermelho"));	
	}
	
	@Test
	public void testremoveItemParaDoacao() throws IllegalAccessException {
		ci.removeItemParaDoacao(1,"12345678901");
		assertEquals(null, ci.exibeItem(1, "12345678901"));	
	}
	
	@Test
	public void testlistaDescritorDeItensParaDoacao() {
		ci.listaDescritorDeItensParaDoacao();
		assertEquals("casaco", ci.listaDescritorDeItensParaDoacao());	
	}
	
	@Test
	public void testlistaItensParaDoacao() {
		ci.listaItensParaDoacao();
		assertEquals("1 - casaco, azul, vermelho, quantidade: 1, doador: joao/12345678901", ci.listaItensParaDoacao());	
	}
	
	@Test
	public void testadicionaItemNecessario() {
		
		assertEquals(1, this.ci.adicionaItemNecessario("98765432178", "casaco", 1, "azul"));	
	}
	
	@Test
	public void testlistaItensNecessarios() {
		
		assertEquals("1 - casaco, azul, quantidade: 1, Receptor: /98765432187", this.ci.listaItensNecessarios());	
	}
	
}
