package br.jus.tjpe.infosistelecom.controle;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class InfraestruturaBean {
	
	private boolean visivel;
	private String valor;
	
	public void mostrar() {

	}
	
	public boolean isVisivel() {
		return visivel;
	}
	
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
}

