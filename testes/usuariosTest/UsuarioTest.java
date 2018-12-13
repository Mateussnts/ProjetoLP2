package usuariosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.Usuario;

class UsuarioTest {
	
	public class TestUsuario{
		
		private Usuario usuario;
		
		
		@Test
		public void testIdNulo() {
			assertThrows(NullPointerException.class,
					() -> new Usuario(null, "joao", "joao.barbosa@ccc.ufcg.edu.br", "(83) 12345-1234", "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testIdVazio() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("", "joao", "joao.barbosa@ccc.ufcg.edu.br", "(83) 12345-1234", "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testNomeNulo() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("12345678901", null, "joao.barbosa@ccc.ufcg.edu.br", "(83) 12345-1234", "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testNomeVazio() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("12345678901", "", "joao.barbosa@ccc.ufcg.edu.br", "(83) 12345-1234", "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testEmailNulo() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("12345678901", "joao", null , "(83) 12345-1234", "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testEmailVazio() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("12345678901", "joao", "" , "(83) 12345-1234", "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testCelularNulo() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("12345678901", "joao", "joao.barbosa@ccc.ufcg.edu.br" , null, "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testCelularVazio() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("12345678901", "joao", "joao.barbosa@ccc.ufcg.edu.br" , "", "PESSOA_FISICA", "Doador"));
		}
		
		@Test
		public void testClasseNula() {
			assertThrows(NullPointerException.class,
					() -> new Usuario("12345678901", "joao", "joao.barbosa@ccc.ufcg.edu.br" , null, "GOVERNO", "Doador"));
		}
		
		
		@Test
		public void testToString() {
			
			usuario = new Usuario("12345678901", "joao", "joao.barbosa@ccc.ufcg.edu.br" ,"(83) 12345-1234", "PESSOA_FISICA", "Doador");
			assertEquals("joao / 12345678901, joao.barbosa@ccc.ufcg.edu.br, (83) 12345-1234, status: Doador", usuario.toString());
		}
		
		@Test
		public void testAdicionaItem() {
			
			usuario.adicionaItem("casaco", 1, "azul, vermelho");
			assertEquals(1, usuario.adicionaItem("casaco", 1, "azul, vermelho"));
			
		}
		
		@Test
		public void testExibirItem() {
			usuario.exibirItem(1);
			assertEquals("1- casaco, azul, vermelho, quantidade: 1", usuario.exibirItem(1));
		}
		
		@Test
		public void testatualizaItem() {
			usuario.atualizaItem(1, 2, "azul, vermelho");
			assertEquals("1- casaco, azul, vermelho, quantidade: 2", usuario.atualizaItem(1, 2, "azul, vermelho"));
		}
		
		@Test
		public void testremoveItem() throws IllegalAccessException {
			usuario.removeItem(1);
			assertEquals(null, usuario.exibirItem(1));
	}
	
  }
}
