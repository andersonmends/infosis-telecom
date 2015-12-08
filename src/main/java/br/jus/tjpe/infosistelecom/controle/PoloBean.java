package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.jus.tjpe.infosistelecom.dao.TecnicoDao;
import br.jus.tjpe.infosistelecom.factory.TecnicoDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Tecnico;

@ManagedBean
@ViewScoped
public class PoloBean {

	private ArrayList<Tecnico> tecnicos;
	private String selectTecnico;
	private String teste;
	
	public String getTeste() {
		return teste;
	}


	public void setTeste(String teste) {
		this.teste = teste;
	}


	public String getSelectTecnico() {
		return selectTecnico;
	}


	public void setSelectTecnico(String selectTecnico) {
		this.selectTecnico = selectTecnico;
	}


	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}


	public void setTecnicos(ArrayList<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}


	@PostConstruct
	public void init() {

		//TecnicoDao dao = TecnicoDaoFactory.createTecnicoDao();
		//tecnicos = dao.listarTudo();
		
		System.out.print("teste");
		
	}
	
	
	public void stateChangeListener()
	{
	    teste = "Teste";
	    System.out.print(selectTecnico);
	}

}
