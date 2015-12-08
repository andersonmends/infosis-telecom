package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.jus.tjpe.infosistelecom.dao.ComarcaDao;
import br.jus.tjpe.infosistelecom.factory.ComarcaDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Comarca;

@ManagedBean
@ViewScoped
public class ComarcaBean {

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

		ComarcaDao dao = ComarcaDaoFactory.createComarcaDao();
		boolean verificador = false;
		ArrayList<Comarca> comarcas = dao.listarTudo();
		cidades.add(comarcas.get(0).getCidade());

		for (Comarca comarca : comarcas) {
			String temp = comarca.getCidade();

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

		ArrayList<String> orgaosTemp = new ArrayList<String>();
		ComarcaDao dao = ComarcaDaoFactory.createComarcaDao();
		ArrayList<Comarca> comarcas = dao.listarTudo();

		for (Comarca comarca : comarcas) {
			if (selectCidade.equals(comarca.getCidade())) {
				orgaosTemp.add(comarca.getOrgao());
			}
		}

		orgaos = orgaosTemp;

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cidade Selecionada", "User Saved"));

	}

	public void stateChangeListenerOrgao() {

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Órgão Selecionado", "User Saved"));
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		ComarcaDao dao = ComarcaDaoFactory.createComarcaDao();
		ArrayList<Comarca> comarcas = dao.listarTudo();

		for (Comarca comarca : comarcas) {

			if (comarca.getCidade().equals(selectCidade)
					&& comarca.getOrgao().equals(selectOrgao)) {
				session.setAttribute("comarca", comarca);
			}
		}

	}
}
