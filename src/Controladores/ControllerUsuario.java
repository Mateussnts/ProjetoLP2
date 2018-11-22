package Controladores;

import java.io.File;
import java.io.IOException;

/**
 * representacao do controle de operacoes(CRUD)
 * dos usuarios.
 */

import java.util.HashMap;
import java.util.Scanner;

import Usuarios.Usuario;

public class ControllerUsuario {
	private HashMap<String, Usuario> listaDoador = new HashMap<>();
	
	public void lerReceptores(String caminho ) throws IOException {
		Scanner leitor = new Scanner(new File(caminho));
		String newLine = null;
		
		while(leitor.hasNextLine()) {
			newLine = leitor.nextLine();
			if(newLine.equals("id,nome,E-mail,celular,classe"))
				continue;
			
			String[] dadosUsuario = newLine.split(",");
			if(dadosUsuario.length != 5) {
				throw new IOException("Campos invalidos");
			}
			Usuario novoUsuario = new Usuario(dadosUsuario[0], dadosUsuario[1], dadosUsuario[2], dadosUsuario[3], dadosUsuario[4]);
			//APAGAR!!!!
			System.out.println(novoUsuario);
			listaDoador.put(dadosUsuario[0], novoUsuario);		
		}
		leitor.close();
	}
	

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
	
	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		Usuario novoDoador = new Usuario(id, nome, email, celular, classe);
		
		if(listaDoador.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja existente: " + id + ".");
		}
		listaDoador.put(id, novoDoador);
		return listaDoador.get(id).getid();
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
