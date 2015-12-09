package br.jus.tjpe.infosistelecom.modelo;


public class Orgao {
	
	private String centroDeCusto;
	private String unidade;
	private String predio;
	private String polo;
	private String cidade;
	private String endereco;
	
	
	public Orgao(){
		
		this.centroDeCusto = "";
		this.unidade = "";
		this.predio = "";
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
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getPredio() {
		return predio;
	}
	public void setPredio(String predio) {
		this.predio = predio;
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
