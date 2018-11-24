package Usuarios;

/**
 * representacao de criacao de um usuario especifico.
 * tendo como atributos nome, email, celular, classe e id.
 * 
 */

public class Usuario {
	private String nome;
	private String email;
	private String celular;
	private String classe;
	private String id;
	private String status;
	
	/**
	 * Metodo construtor do usuario.
	 * @param nome
	 * 		representacao em string do nome do usuario.
	 * @param email
	 * 		representacao em string do email do usuario.
	 * @param celular
	 * 		representacao em string do celular do usuario.
	 * @param classe
	 * 		representacao em string da classe do usuario.
	 * @param id
	 * 		representacao em string da id do ususario.
	 * @param status 
	 */
	
	public Usuario(String id, String nome, String email, String celular, String classe) {
		
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");
		}
		
		if(email == null || email.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: email nao pode ser vazio ou nulo.");
		}
		
		if(celular == null || celular.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: celular nao pode ser vazio ou nulo.");
		}
		
		if(classe == null || classe.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: classe nao pode ser vazia ou nula.");
		}
		
		if(id == null || id.equals("")) {
			throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}
		
		if(!classe.equals("PESSOA_FISICA") && !classe.equals("IGREJA") && !classe.equals("ONG")
			&& !classe.equals("ORGAO_PUBLICO_ESTADUAL") && !classe.equals("ASSOCIACAO") && !classe.equals("SOCIEDADE") && !classe.equals("ORGAO_PUBLICO_MUNICIPAL")) {
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
		
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.classe = classe;
		this.id = id;
		this.status = null;
	}

	/**
	 * Metodos acessadores dos atributos do usuario.
	 */
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}

	public String getCelular() {
		return celular;
	}
	
	public String getclasse() {
		return classe;
	}
	
	public String getid() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	/**
	 * Metodos modificadores dos atributos do usuario.
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public void setclasse(String classe) {
		this.classe = classe;
	}

	public void setid(String id) {
		this.id = id;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metodo que retorna a representacao textual do usuario
	 * tendo como parametros os atributos do usuario.
	 */
	
	@Override
	public String toString() {
		return nome + "/" + id + ", " + email + ", " + celular + ", " + "status: " + status;
	}

	/**
	 * Hashcode and equals.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	
}	
	