package Controladores;

import java.util.ArrayList;

/**
 * representacao do controle de operacoes(CRUD)
 * dos usuarios.
 */

import java.util.HashMap;
import Usuarios.Usuario;

public class ControllerUsuario {
	private HashMap<String, Usuario> listaDoador = new HashMap<>();
	private ArrayList<String> descritores = new ArrayList<String>();
	
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
	
	public void adicionaDescritor(String descricao) {
		
		if(descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");
		}
		
		if(descritores.contains(descricao)) {
			throw new IllegalArgumentException("Descritor de Item ja existente: " + this.descritores + ".");
		}
		
		descritores.add(descricao);
		
	}
	
	public String adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tag) {
		
		return "" ;
		
	}

	















}
