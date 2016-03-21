package br.jus.tjpe.infosistelecom.modelo;

public class Usuario {

	
	private String matricula;
	private String login;
	private String permissao;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	public String getMatricula() {
		return matricula;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
