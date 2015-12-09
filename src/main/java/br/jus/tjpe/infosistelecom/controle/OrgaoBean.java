package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.factory.OrgaoDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;

@ManagedBean
@SessionScoped
public class OrgaoBean {

	private ArrayList<String> cidades = new ArrayList<String>();
	private ArrayList<String> orgaos = new ArrayList<String>();
	private String selectCidade;
	private String selectOrgao;

	public ArrayList<String> getCidades() {
		return cidades;
	}

	public void setCidades(ArrayList<String> cidades) {
		this.cidades = cidades;
	}

	public ArrayList<String> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(ArrayList<String> orgaos) {
		this.orgaos = orgaos;
	}

	public String getSelectCidade() {
		return selectCidade;
	}

	public void setSelectCidade(String selectCidade) {
		this.selectCidade = selectCidade;
	}

	public String getSelectOrgao() {
		return selectOrgao;
	}

	public void setSelectOrgao(String selectOrgao) {
		this.selectOrgao = selectOrgao;
	}

	@PostConstruct
	public void init() {

		OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
		boolean verificador = false;
		ArrayList<Orgao> orgaos = dao.listarTudo();
		cidades.add(orgaos.get(0).getCidade());

		for (Orgao orgao : orgaos) {
			String temp = orgao.getCidade();

			for (int i = 0; i < cidades.size(); i++) {

				if (temp.equals(cidades.get(i))) {
					verificador = true;
				}
			}

			if (verificador == false) {
				cidades.add(temp);

			}

			verificador = false;

		}

	}

	public void stateChangeListenerCidade() {

		System.out.println(selectCidade);
		ArrayList<String> orgaosTemp = new ArrayList<String>();
		OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
		ArrayList<Orgao> orgaos = dao.listarTudo();

		for (Orgao orgao : orgaos) {
			if (selectCidade.equals(orgao.getCidade())) {
				orgaosTemp.add(orgao.getUnidade());
			}
		}

		this.orgaos = orgaosTemp;

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cidade Selecionada", null));

	}


	public void stateChangeListenerOrgao() {

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Órgão Selecionado", null));
		
		OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
		ArrayList<Orgao> orgaos = dao.listarTudo();

		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		
		for (Orgao comarca : orgaos) {

			if (comarca.getCidade().equals(selectCidade)
					&& comarca.getUnidade().equals(selectOrgao)) {
			
				session.setAttribute("comarca", comarca);
				
			}
		}

	}

}
