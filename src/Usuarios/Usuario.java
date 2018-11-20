package Usuarios;

/**
 * representacao de criacao de um usuario especifico.
 * tendo como atributos nome, email, celular, status e id.
 * 
 */

public class Usuario {
	private String nome;
	private String email;
	private String celular;
	private String status;
	private String id;
	
	/**
	 * Metodo construtor do usuario.
	 * @param nome
	 * 		representacao em string do nome do usuario.
	 * @param email
	 * 		representacao em string do email do usuario.
	 * @param celular
	 * 		representacao em string do celular do usuario.
	 * @param status
	 * 		representacao em string da status do usuario.
	 * @param id
	 * 		representacao em string da id do ususario.
	 */
	
	public Usuario(String nome, String email, String celular, String status, String id) {
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.status = status;
		this.id = id;
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
	
	public String getstatus() {
		return status;
	}
	
	public String getid() {
		return id;
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


	public void setstatus(String status) {
		this.status = status;
	}


	public void setid(String id) {
		this.id = id;
	}

	/**
	 * Metodo que retorna a representacao textual do usuario
	 * tendo como parametros os atributos do usuario.
	 */
	
	@Override
	public String toString() {
		return nome +  " / " + id + ", " + email + ", " + celular + ", " + status;
	}

	/**
	 * Hashcode and equals.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return true;
	}
}
