package br.jus.tjpe.infosistelecom.modelo;


public class Orgao {
	
	private String centroDeCusto;
	private String localidade;
	private String suborgao;
	private String centroDeCustoAntigo;
	private String polo;
	private String cidade;
	private String endereco;
	
	
	public Orgao(){
		
		this.centroDeCusto = "";
		this.centroDeCustoAntigo = "";
		this.localidade = "";
		this.suborgao = "";
		this.cidade = "";
		this.polo = "";	
		this.endereco = "";
		this.centroDeCusto = "";
		
	}

	public String getCentroDeCusto() {
		return centroDeCusto;
	}
	public void setCentroDeCusto(String centroDeCustoOrgao) {
		this.centroDeCusto = centroDeCustoOrgao;
	}
	public String getCentroDeCustoAntigo() {
		return centroDeCustoAntigo;
	}
	public void setCentroDeCustoAntigo(String centroDeCustoOrgaoSuperior) {
		this.centroDeCustoAntigo = centroDeCustoOrgaoSuperior;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String nome) {
		this.localidade = nome;
	}
	public String getSuborgao() {
		return suborgao;
	}
	public void setSuborgao(String Suborgao) {
		this.suborgao = Suborgao;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPolo() {
		return polo;
	}
	public void setPolo(String regiao) {
		this.polo = regiao;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
