package br.jus.tjpe.infosistelecom.modelo;

import java.util.ArrayList;

public class Polo {
	
	private String nome;
	private ArrayList<Comarca> comarca;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Comarca> getCidade() {
		return comarca;
	}
	public void setCidade(ArrayList<Comarca> comarca) {
		this.comarca = comarca;
	}

}
