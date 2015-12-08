package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.jus.tjpe.infosistelecom.modelo.Material;

;

@ManagedBean
@SessionScoped
public class MaterialBean {

	private List<Material> listaMaterial = new ArrayList<Material>();
	private String nome = "";
	private int quantidade = 0;

	@PostConstruct
	public void init() {

		Material teste = new Material();
		teste.setNome("teste");
		teste.setQuantidade(2);
		listaMaterial.add(teste);

		Material teste1 = new Material();
		teste.setNome("teste1");
		teste.setQuantidade(2);
		listaMaterial.add(teste1);
	}

	public String add() {
		Material material = new Material();
		material.setNome(this.nome);
		material.setQuantidade(this.quantidade);
		listaMaterial.add(material);

		this.nome = "";
		this.quantidade = 0;

		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(ArrayList<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}
}
