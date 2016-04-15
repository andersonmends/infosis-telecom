package br.jus.tjpe.infosistelecom.controle;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.jus.tjpe.infosistelecom.factory.LDAPConnectionFactory;

import br.jus.tjpe.infosistelecom.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {

	private Usuario usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	public void submit() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);

		usuario.setLogin(login);

		boolean auth = LDAPConnectionFactory.authentication(login, senha);
		try {
			if (auth == true) {
				context.addMessage(null, new FacesMessage("Login efetuado com sucesso"));
				try {
					System.out.println("Login efetuado com sucesso");
//					HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//					session.setAttribute("usuario", usuario);
					
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
					context.getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				context.addMessage(null, new FacesMessage("Login falhou"));
				
			}

		} catch (NullPointerException e) {
			context.addMessage(null, new FacesMessage("Login falhou"));
			System.out.println("Login Falhou");
		}

		// try {
		// if (usuario.getLogin().equals(login)
		// && usuario.getSenha().equals(senha)) {
		// context.addMessage(null, new FacesMessage(
		// "Login efetuado com sucesso"));
		// try {
		//
		// HttpSession session = (HttpSession) context
		// .getExternalContext().getSession(false);
		// session.setAttribute("usuario", usuario);
		// context.getExternalContext().redirect("index.xhtml");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// } else {
		// context.addMessage(null, new FacesMessage("Login falhou"));
		// }
		//
		// } catch (NullPointerException e) {
		// context.addMessage(null, new FacesMessage("Login falhou"));
		// }
	}

	public void logout() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//		session.removeAttribute("usuario");
		context.addMessage(null, new FacesMessage("Logout efetuado com sucesso"));
		context.getExternalContext().redirect("login.xhtml");

	}

}
