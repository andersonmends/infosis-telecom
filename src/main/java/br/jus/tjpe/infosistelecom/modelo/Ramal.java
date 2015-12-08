package br.jus.tjpe.infosistelecom.modelo;

public class Ramal {

	private String fone;
	private String circuito;
	private String situacao;
	private String categoriaDiurna;
	private String categoriaNoturna;
	private String tipoDeRamal;
	private Orgao orgao;
	private String divulgacao;
	private String nomenclatura;
	private String dataDeAtivacao;
	private String compartilhadoCom;
	private String observacoes;
	private String centroDeCusto;

	public Ramal() {

		this.fone = "";
		this.circuito = "";
		this.situacao = "";
		this.categoriaDiurna = "";
		this.categoriaNoturna = "";
		this.tipoDeRamal = "";
		this.orgao = new Orgao();
		this.divulgacao = "";
		this.nomenclatura = "";
		this.dataDeAtivacao = "";
		this.compartilhadoCom = "";
		this.observacoes = "";
		this.centroDeCusto = "";

	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getCategoriaNoturna() {
		return categoriaNoturna;
	}

	public void setCategoriaNoturna(String categoriaNoturna) {
		this.categoriaNoturna = categoriaNoturna;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomeclatura) {
		this.nomenclatura = nomeclatura;
	}

	public String getTipoDeRamal() {
		return tipoDeRamal;
	}

	public void setTipoDeRamal(String tipoDeRamal) {
		this.tipoDeRamal = tipoDeRamal;
	}

	public String getDataDeAtivacao() {
		return dataDeAtivacao;
	}

	public void setDataDeAtivacao(String dataDeAtivacao) {
		this.dataDeAtivacao = dataDeAtivacao;
	}

	public String getCompartilhadoCom() {
		return compartilhadoCom;
	}

	public void setCompartilhadoCom(String compartilhadoCom) {
		this.compartilhadoCom = compartilhadoCom;
	}

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

	public String getDivulgacao() {
		return divulgacao;
	}

	public void setDivulgacao(String divulgacao) {
		this.divulgacao = divulgacao;
	}

	public String getCategoriaDiurna() {
		return categoriaDiurna;
	}

	public void setCategoriaDiurna(String categoria) {
		this.categoriaDiurna = categoria;
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


}
