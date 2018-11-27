package Controladores;


import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Item.Item;
import Usuarios.Usuario;


/**
 * representacao do controle de operacoes(CRUD)
 * dos usuarios.
 */

public class Controller {

	private ArrayList<Usuario> listaUsuario = new ArrayList<>();
	private ArrayList<String> descritores = new ArrayList<String>();
	private HashMap<String, Item> listaItens = new HashMap<String, Item>();
	private int idItem = 0;
						
	/**
	 * Metodo de leitura dos arquivos(CSV) para cadastro de usuarios e atualizacao das 
	 * informacoes dos usuarios.
	 * @param caminho
	 * 		caminho onde o arquivo esta armazenado
	 * @throws IOException
	 */
	
	public void lerReceptores(String caminho ) throws IOException {
        Scanner leitor = new Scanner(new File(caminho));
        String newLine = null;

        while(leitor.hasNextLine()) {
            newLine = leitor.nextLine();
            if(newLine.equals("id,nome,e-mail,celular,classe"))
            	continue;
            
            String[] dadosUsuario = newLine.split(",");
            
            Usuario novoUsuario = new Usuario(dadosUsuario[0], dadosUsuario[1], dadosUsuario[2], dadosUsuario[3], dadosUsuario[4]);
            
            if(buscarUsuarioId(novoUsuario.getid()) != null) {
            	atualizaUsuario(novoUsuario.getid(),
            					novoUsuario.getNome(),
            					novoUsuario.getEmail(),
            					novoUsuario.getCelular());
            } else {
                listaUsuario.add(novoUsuario);
                buscarUsuarioId(dadosUsuario[0]).setStatus("receptor");
            }
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
		if(buscarUsuarioId(id) != null) {
			throw new IllegalArgumentException("Usuario ja existente: " + id + ".");
		}
		
		Usuario novoDoador = new Usuario(id, nome, email, celular, classe);
		novoDoador.setStatus("doador");
		listaUsuario.add(novoDoador);
		
		return novoDoador.getid();
	}

	/**
	 * Metodo de pesquisa de usuarios cadastrados a partir do seu numero de identificacao.
	 * @param id
	 * 		representacao em string do numero de identificacao do usuario.
	 * @return
	 * 		retorna a represenatcao textual do usuario associado ao numero de identificacao.
	 */
	
	public String pesquisaUsuarioPorId(String id) {
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		Usuario usuario = buscarUsuarioId(id);
		
		if(usuario == null) 
			throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");
		
		return usuario.toString();
	}
	
	/**
	 * Metodo de pesquisa de usuarios cadastrados a partir do seu nome.
	 * @param nome
	 * 		representacao do nome do usuario.
	 * @return
	 * 		retorna a representacao do usuario associado ao nome passado.
	 */
	
	public String pesquisaUsuarioPorNome(String nome) {
		if(nome == null || nome.trim().equals(""))
			throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");
		
		if(buscarUsuarioNome(nome) == null)
			throw new IllegalArgumentException("Usuario nao encontrado: " + nome + ".");
		
		String saida = "";
		for (int i = 0; i < listaUsuario.size(); i++) {
			Usuario usuario = listaUsuario.get(i);
			if(usuario.getNome().equals(nome)) {
				if(!saida.equals("")) {
					saida += " | " + usuario.toString();
				} else {
					saida += usuario.toString();
				}
			}
		}
		return saida;
	}
	
	/**
	 * Metodo de atualizacao de informacoes de usuarios.
	 * @param id
	 * 		representacao do numero de identificacao do usuario que sera alterado.
	 * @param nome
	 * 		representacao do nome do usuario que sera alterado.
	 * @param email
	 *		representacao do email do usuario que sera alterado.
	 * @param celular 
	 * 		representacao do numero de celular do usuario que sera alterado.
	 */
	
	public String atualizaUsuario(String id, String nome, String email, String celular) {
		String saida = "";
		
		if(id == null || id.equals("")) 
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		Usuario usuario = buscarUsuarioId(id);
		
		if(usuario == null)
			throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");
		
		else {
			for (int i = 0; i < listaUsuario.size(); i++) {
				if(listaUsuario.get(i).equals(usuario)) {
					if(!(nome == null || nome.equals(""))) listaUsuario.get(i).setNome(nome);
					if(!(email == null || email.equals(""))) listaUsuario.get(i).setEmail(email);
					if(!(celular == null || celular.equals(""))) listaUsuario.get(i).setCelular(celular);
					saida = listaUsuario.get(i).toString();
				}
			}
		}
		return saida;
	}

	/**
	 * Metodo de remorcao de usuarios do sistema a partir do seu numero de identificacao.
	 * @param id
	 * 		numero de identificacao do usuario que sera deletado.
	 */
	
	public void removeUsuario(String id) {
		Usuario usuario = buscarUsuarioId(id);
		
		if(id == null || id.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}
		if(buscarUsuarioId(id) == null) {
			throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");
		}
		
		listaUsuario.remove(usuario);
	}
	
	public String adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tag) {
		
		return "" ;
		
	}

	/**
	 * Metodo com finalidade de buscar usuarios especifico que estao cadastrados no sistema
	 * a partir de seu numero de identificacao.
	 * @param id
	 * 		recebe o numero de identificacao do usuario.
	 * @return
	 * 		retorno o usuario associado
	 */
	
	private Usuario buscarUsuarioId(String id) {
		Usuario usuario = null;
		for (int i = 0; i < listaUsuario.size(); i++) {
			if(listaUsuario.get(i).getid().equals(id)) {
				usuario = listaUsuario.get(i);
			}
		}
		return usuario;
	}
	
	/**
	 * Metodo com finalidade de buscar usuarios especifico que estao cadastrados no sistema
	 * a partir de seu nome.
	 * @param nome
	 * 		recebe o nome do usuario como identificacao.
	 * @return
	 * 		retorno o usuario associado
	 */
	
	private Usuario buscarUsuarioNome(String nome) {
		Usuario usuario = null;
		for (int i = 0; i < listaUsuario.size(); i++) {
			if(listaUsuario.get(i).getNome().equals(nome)) {
				usuario = listaUsuario.get(i);
			}
		}
		return usuario;
	}
	
	public void adicionaDescritor(String descricao) {
		
		if(descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");
		}
		
		if(descritores.contains(descricao)) {
			throw new IllegalArgumentException("Descritor de Item ja existente: " + this.descritores + ".");
		}
	}
	
	public String adicionaItemParaDoacao(String idDoador, String descricao, int quantidade, String tags) {
		
		if(descricao.equals("") || descricao == null) {
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");
		}
		
		if(quantidade <= 0) {
			throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");
		}
		
		
		//
		
		
		listaItens.put(idDoador, new Item(idDoador, descricao,quantidade, tags));
		return "";
		
	}
	
	
	
	
	
	
	
	
}
