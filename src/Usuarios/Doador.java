package Usuarios;

public class Doador extends Usuario{
	private String classe;

	public Doador(String nome, String email, String celular, String status, String id, String classe) {
		super(nome, email, celular, status, id);
		
		if(!classe.equals("PESSOA_FISICA") && !classe.equals("IGREJA") && !classe.equals("ONG")
			&& !classe.equals("ORGAO_PUBLICO_ESTADUAL") && !classe.equals("ORGAO_PUBLICO_FEDERAL")
			&& !classe.equals("ASSOCIACAO") && classe.equals("SOCIEDADE")) {
			throw new IllegalArgumentException("\"Entrada invalida: opcao de classe invalida.");
		}
		
		this.classe = classe;
	}

	public String getClasse() {
		return classe;
	}
}	
