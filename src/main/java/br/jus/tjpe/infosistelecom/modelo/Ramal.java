package br.jus.tjpe.infosistelecom.modelo;

public class Ramal {

	private String fone;
	private String circuito;
	private String situacao;
	private String categoria;
	private String tipoDeRamal;
	private Orgao orgao;
	private String unidade;
	private String local;
	// private String dataDeAtivacao;
	 private String observacoes;
	private String centroDeCusto;

	public Ramal() {

		this.fone = "";
		this.circuito = "";
		this.situacao = "";
		this.categoria = "";
		this.tipoDeRamal = "";
		this.orgao = new Orgao();
		this.unidade = "";
		this.local = "";
		// this.dataDeAtivacao = "";
		 this.observacoes = "";
		this.centroDeCusto = "";

	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getTipoDeRamal() {
		return tipoDeRamal;
	}

	public void setTipoDeRamal(String tipoDeRamal) {
		this.tipoDeRamal = tipoDeRamal;
	}

	// public String getDataDeAtivacao() {
	// return dataDeAtivacao;
	// }
	//
	// public void setDataDeAtivacao(String dataDeAtivacao) {
	// this.dataDeAtivacao = dataDeAtivacao;
	// }

	 public String getObservacoes() {
	 return observacoes;
	 }
	
	 public void setObservacoes(String observacoes) {
	 this.observacoes = observacoes;
	 }

	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public String getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(String centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String numero) {
		this.fone = numero;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
