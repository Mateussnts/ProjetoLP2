package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entidades.Item;
import entidades.Usuario;

/**
 * representacao do controller geral de operacoes do sistema, responsavel por ler a classe
 * de controle dos usuarios e dos itens e ser chamado pela fachada com as respectivas operaçoes
 * do sistema completo. Criacao de controller estatico para que o controller de itens possa ter acesso a lista
 * de usuario e assim aplicar a associacao de itens aos usuarios doadores.
 */

public class ControllerSistema {
	
	private ControllerUsuario controllerUsuario;
	private ControllerItem controllerItem;
	
	public ControllerSistema() {
		controllerUsuario = new ControllerUsuario();
		controllerItem = new ControllerItem(controllerUsuario);
	}

	public void lerReceptores(String caminho) throws IOException {
		this.controllerUsuario.lerReceptores(caminho);
	}

	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		return controllerUsuario.adicionaDoador(id, nome, email, celular, classe);
	}

	public String pesquisaUsuarioPorId(String id) {
		return controllerUsuario.pesquisaUsuarioPorId(id);
	}

	public String pesquisaUsuarioPorNome(String nome) {
		return controllerUsuario.pesquisaUsuarioPorNome(nome);
	}

	public String atualizaUsuario(String id, String nome, String email, String celular) {
		return controllerUsuario.atualizaUsuario(id, nome, email, celular);
	}

	public void removeUsuario(String id) {
		this.controllerUsuario.removeUsuario(id);
	}

	public void adicionaDescritor(String descricao) {
		this.controllerItem.adicionaDescritor(descricao);
	}

	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		return controllerItem.adicionaItemParaDoacao(idDoador,descricaoItem,quantidade,tags);
	}

	public String exibeItem(int id, String idDoador) {
		return controllerItem.exibeItem(id,idDoador);
	}

	public String atualizaItemParaDoacao(int id, String idDoador, int quantidade, String tags) {
		return controllerItem.atualizaItemParaDoacao(id, idDoador, quantidade, tags);
	}

	public void removeItemParaDoacao(int id, String idDoador) throws IllegalAccessException {
		this.controllerItem.removeItemParaDoacao(id,idDoador);
	}

	public String listaItensParaDoacao() {
		return this.controllerItem.listaItensParaDoacao();
	}

	public String listaDescritorDeItensParaDoacao() {
		return this.controllerItem.listaDescritorDeItensParaDoacao();
	}
	
	public String pesquisaItemParaDoacaoPorDescricao(String desc) {
		return this.controllerItem.pesquisaItemParaDoacaoPorDescricao(desc);
	}

	public int adicionaItemNecessario(String idReceptor, String descricaoItem, int quantidade, String tags) {
		return this.controllerItem.adicionaItemNecessario(idReceptor, descricaoItem, quantidade, tags);
	}

	public String listaItensNecessarios() {
		return this.controllerItem.listaItensNecessarios();
	}

	public String atualizaItemNecessario(int id, String idReceptor, int quantidade, String tags) {
		return this.controllerItem.atualizaItemNecessario(id, idReceptor, quantidade, tags);
	}

	public void removeItemNecessario(int id, String idReceptor) throws IllegalAccessException {
		this.controllerItem.removeItemNecessario(id, idReceptor);
	}
	
	public String match(String idReceptor, int idItemNecessario) {
		return this.controllerItem.match(idReceptor, idItemNecessario);
	}

	public void fechaSistema(){
		try {
			File fileItens = new File("arquivos_sistema/itens.dat");
	        @SuppressWarnings("resource")
			ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream(fileItens));
	        output1.writeObject(ControllerItem.itens);
	        
			File fileItensNecessarios = new File("arquivos_sistema/itens_necessarios.dat");
	        @SuppressWarnings("resource")
			ObjectOutputStream output2 = new ObjectOutputStream(new FileOutputStream(fileItensNecessarios));
	        output2.writeObject(ControllerItem.itensNecessarios);
	        
			File fileUsuarios = new File("arquivos_sistema/usuarios.dat");
	        @SuppressWarnings("resource")
			ObjectOutputStream output3 = new ObjectOutputStream(new FileOutputStream(fileUsuarios));
	        output3.writeObject(ControllerUsuario.listaUsuario);
	    }
	    catch(Exception e){
	    	System.out.println(e.toString());
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void iniciaSistema(){
		try {
			File fileItens = new File("arquivos_sistema/itens.dat");
            @SuppressWarnings("resource")
			ObjectInputStream input1 = new ObjectInputStream(new FileInputStream(fileItens));
            ControllerItem.itens = ((ArrayList<Item>) input1.readObject());
            
			File fileItensNecessarios = new File("arquivos_sistema/itens_necessarios.dat");
            @SuppressWarnings("resource")
			ObjectInputStream input2 = new ObjectInputStream(new FileInputStream(fileItensNecessarios));
            ControllerItem.itensNecessarios = ((ArrayList<Item>) input2.readObject());
            
			File fileUsuarios = new File("arquivos_sistema/usuarios.dat");
            @SuppressWarnings("resource")
			ObjectInputStream input3 = new ObjectInputStream(new FileInputStream(fileUsuarios));
            ControllerUsuario.listaUsuario = ((ArrayList<Usuario>) input3.readObject());
		}
		catch(Exception e){
            System.out.println(e.toString());
        }
	}
}
