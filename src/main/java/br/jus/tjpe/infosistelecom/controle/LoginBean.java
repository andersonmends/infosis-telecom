package br.jus.tjpe.infosistelecom.controle;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.jus.tjpe.infosistelecom.dao.TecnicoDao;
import br.jus.tjpe.infosistelecom.factory.TecnicoDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Tecnico;

@ManagedBean
@SessionScoped
public class LoginBean<Usuario> {

	private Tecnico usuario;
	private String login;
	private String senha;

	public LoginBean() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Tecnico getUsuario() {
		return usuario;
	}

	public void setUsuario(Tecnico usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void init() {
		usuario = new Tecnico();
	}

	public void submit() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

//		TecnicoDao dao = TecnicoDaoFactory.createTecnicoDao();

//		usuario = dao.buscarPorEmail(login);
		
		
		usuario.setLogin("a");
		usuario.setSenha("a");
		

		try {
			if (usuario.getLogin().equals(login)
					&& usuario.getSenha().equals(senha)) {
				context.addMessage(null, new FacesMessage(
						"Login efetuado com sucesso"));
				try {

					HttpSession session = (HttpSession) context
							.getExternalContext().getSession(false);
					session.setAttribute("usuario", usuario);
					context.getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				context.addMessage(null, new FacesMessage("Login falhou"));
			}

		} catch (NullPointerException e) {
			context.addMessage(null, new FacesMessage("Login falhou"));
		}
	}

}
