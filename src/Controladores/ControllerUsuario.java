package Controladores;

/**
 * representacao do controle de operacoes(CRUD)
 * dos usuarios.
 */

import java.util.HashMap;
import Usuarios.Usuario;

public class ControllerUsuario {
	private HashMap<String, Usuario> listaDoador = new HashMap<>();
	
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
		
		if(listaDoador.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja existente: " + id + ".");
		}
		listaDoador.put(id, novoDoador);
	}

	public String pesquisaUsuarioPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String pesquisaUsuarioPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizaUsuario(String id, String parametro, String novoParametro) {
		// TODO Auto-generated method stub
		
	}

	public void removeUsuario(String id) {
		// TODO Auto-generated method stub
		
	}

	















}
