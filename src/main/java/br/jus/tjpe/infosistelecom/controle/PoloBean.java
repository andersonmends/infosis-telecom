package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.jus.tjpe.infosistelecom.dao.UsuarioDao;
import br.jus.tjpe.infosistelecom.factory.UsuarioDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Usuario;

@ManagedBean
@ViewScoped
public class PoloBean {

	private ArrayList<Usuario> usuarios;
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


	public ArrayList<Usuario> getTecnicos() {
		return usuarios;
	}


	public void setTecnicos(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@PostConstruct
	public void init() {

		//UsuarioDao dao = UsuarioDaoFactory.createTecnicoDao();
		//usuarios = dao.listarTudo();
		
		System.out.print("teste");
		
	}
	
	
	public void stateChangeListener()
	{
	    teste = "Teste";
	    System.out.print(selectTecnico);
	}

}
