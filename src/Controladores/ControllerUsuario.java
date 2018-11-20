package Controladores;

/**
 * representacao do controle de operacoes(CRUD)
 * dos usuarios.
 */

import java.util.HashMap;
import Usuarios.Usuario;

public class ControllerUsuario {
	private HashMap<String, Usuario> listDoador = new HashMap<>();
	
	/**
	 * Metodo de cadastro de usuarios doadores no sistema.
	 * * @param nome
	 * 		representacao em string do nome do usuario.
	 * @param email
	 * 		representacao em string do email do usuario.
	 * @param celular
	 * 		representacao em string do celular do usuario.
	 * @param status
	 * 		representacao em string da status do usuario.
	 * @param id
	 * 		representacao em string da identificao do ususario.
	 */
	
	public void adicionaDoador(String id, String nome, String email, String celular, String classe) {
		Usuario novoDoador = new Usuario(id, nome, email, celular, classe);
		
		if(nome.equals("") || nome.equals(null)) {
			throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");
		}
		
		if(email.equals("") || nome.equals(null)) {
			throw new IllegalArgumentException("Entrada invalida: email nao pode ser vazio ou nulo.");
		}
		
		if(celular.equals("") || celular.equals(null)) {
			throw new IllegalArgumentException("Entrada invalida: celular nao pode ser vazio ou nulo.");
		}
		
		if(classe.equals("") || classe.equals(null)) {
			throw new IllegalArgumentException("Entrada invalida: classe nao pode ser vazia ou nula.");
		}
		
		if(id.equals("") || id.equals(null)) {
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}
		
		if(listDoador.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja existente: " + id + ".");
		}
		else {
			listDoador.put(id, novoDoador);
		}
	}

	















}
