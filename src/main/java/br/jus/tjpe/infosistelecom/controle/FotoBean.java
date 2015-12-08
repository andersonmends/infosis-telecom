package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.jus.tjpe.infosistelecom.dao.FotoDao;
import br.jus.tjpe.infosistelecom.factory.FotoDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Comarca;
import br.jus.tjpe.infosistelecom.modelo.Foto;

/**
 * Session Bean implementation class FotoBean
 */
@ManagedBean
public class FotoBean {

	private ArrayList<Foto> fotos = new ArrayList<Foto>();

	@PostConstruct
	public void init() {
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)contexto.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		Comarca comarca = (Comarca) session.getAttribute("comarca");
		
		Comarca c = new Comarca();
		c.setCidade("Agrestina");
		
		// cria-se o dao para fazer a consultado ao banco passando a comarca que queremos a foto
		FotoDao dao = FotoDaoFactory.createFotoDao();
		fotos = dao.listarTudo(c);

	}

	public ArrayList<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}

}
