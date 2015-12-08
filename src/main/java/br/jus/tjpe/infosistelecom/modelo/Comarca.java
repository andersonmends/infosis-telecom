package br.jus.tjpe.infosistelecom.modelo;

import java.util.ArrayList;

public class Comarca {
	
	private long centroDeCusto;
	private String orgao;
	private String cidade;
	private String polo;
	private String complemento;
	private String endereco;
	private String cep;
	private String numero;
	private String bairro;
	
	public long getCentroDeCusto() {
		return centroDeCusto;
	}
	public void setCentroDeCusto(long centroDeCsuto) {
		this.centroDeCusto = centroDeCsuto;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String nome) {
		this.cidade = nome;
	}
	public String getPolo() {
		return polo;
	}
	public void setPolo(String polo) {
		this.polo = polo;
	}



}
