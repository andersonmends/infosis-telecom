package br.jus.tjpe.infosistelecom.controle;

import br.jus.tjpe.infosistelecom.dao.LogDao;
import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.dao.UsuarioDao;
import br.jus.tjpe.infosistelecom.factory.LogDaoFactory;
import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;
import br.jus.tjpe.infosistelecom.factory.UsuarioDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Log;
import br.jus.tjpe.infosistelecom.modelo.Ramal;
import br.jus.tjpe.infosistelecom.modelo.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class ConsultaBean {

	private ArrayList<Ramal> ramais = new ArrayList<Ramal>();
	private List<Ramal> ramaisFilter;
	private Ramal selectRamal = new Ramal();
	private Ramal ramalTemp = new Ramal();
	private Log log = new Log();
	private String readOnly = "true"; // configura o tipo de readOnly do usuário, caso seja 0, ele pode editar informações do ramal
	private String renderedInputText = "true"; 
	private String renderedSelectMenu = "false";

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getRenderedInputText() {
		return renderedInputText;
	}

	public void setRenderedInputText(String renderedInputText) {
		this.renderedInputText = renderedInputText;
	}

	public String getRenderedSelectMenu() {
		return renderedSelectMenu;
	}

	public void setRenderedSelectMenu(String renderedSelectMenu) {
		this.renderedSelectMenu = renderedSelectMenu;
	}

	public Ramal getRamalTemp() {
		return ramalTemp;
	}

	public void setRamalTemp(Ramal ramalTemp) {
		this.ramalTemp = ramalTemp;
	}


	public List<Ramal> getRamaisFilter() {
		return ramaisFilter;
	}

	public void setRamaisFilter(List<Ramal> ramaisFilter) {
		this.ramaisFilter = ramaisFilter;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Ramal getSelectRamal() {
		return selectRamal;
	}

	public void setSelectRamal(Ramal selectRamal) {
		this.selectRamal = selectRamal;
	}

	public ArrayList<Ramal> getRamais() {
		return ramais;
	}

	public void setRamais(ArrayList<Ramal> ramais) {
		this.ramais = ramais;
	}

	@PostConstruct
	public void init() {

		ramais = new ArrayList<Ramal>();
		RamalDao dao = RamalDaoFactory.createRamalDao();
		ramais = dao.listarTudo();
		
		
		
		
		// ramais = null;
		// recupera a hora de acordo com o servidor TOMCAT, porém não sei o
		// motivo está retornando a hora de fuso horário (timezone) diferente
		Date data = new Date();

		// formatador de data do tipo Date, onde os parametros yyyy, MM, etc,
		// são identificadores definidos na classe, então para outras
		// formatações, é necessário verificar a documentação da classe
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// timezone define um timezone para a classe Calendar, como está meio
		// que com bug o TOMCAT, utilizei outra forma de recuperar a data que
		// preciso
		TimeZone timeZone = TimeZone.getTimeZone("America/Recife");
		Calendar c1 = Calendar.getInstance(timeZone);
		c1.setTimeZone(timeZone);

		// criando Date utilizei os metodos decripitadors, porque foi a única
		// maneira que encontrei de recuperar a data para ser formatada pelo
		// SimpleDateFormat, uma vez que usando c1.getTime não estava retonando
		// o novo timezone que define em 72.
		data = c1.getTime();
		data.setHours(c1.get(Calendar.HOUR_OF_DAY));
		data.setMinutes(c1.get(Calendar.MINUTE));
		data.setSeconds(c1.get(Calendar.SECOND));
		String dataFormatada = formatDate.format(data);

		System.out.println(dataFormatada);
			
		

	}

	public void atualizar() {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Campo Atualizado"));
		RamalDao daoRamal = RamalDaoFactory.createRamalDao();
		daoRamal.atualizar(selectRamal);

		log.setCategoriaNew(selectRamal.getCategoria());
		log.setTipoDeRamalNew(selectRamal.getTipoDeRamal());
		log.setLocalNew(selectRamal.getLocal());
		log.setObservacoesNew(selectRamal.getObservacoes());

		LogDao daoLog = LogDaoFactory.createLogDaoFactory();
		daoLog.adicionar(log);
		this.init();

	}

	public void cancelar() {

		this.init();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ação Cancelada"));
		ramalTemp = new Ramal();
	}

	public void remover() {

		RamalDao daoRamal = RamalDaoFactory.createRamalDao();
		daoRamal.remover(ramalTemp);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ramal Removido"));
		// ramalTemp = new Ramal();
		this.init();
	}

	public void onRowSelect(SelectEvent event) {
		
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			System.out.println(usuario.getLogin());
			
			UsuarioDao dao = UsuarioDaoFactory.createUsuarioDao();
			Usuario user = new Usuario();
			
			user.setLogin(usuario.getLogin());
			
			user = dao.buscar(user);
			
			if (user.getPermissao().equals("0")) {
				readOnly = "false";
				renderedInputText = "false";
				renderedSelectMenu = "true";
				System.out.println("teste");
			}else {
				readOnly = "true";
				renderedInputText = "true";
				renderedSelectMenu = "false";
			}
		} catch (Exception e) {
			readOnly = "true";
			renderedInputText = "true";
			renderedSelectMenu = "false";
		}

		
		
		// // recupera a hora de acordo com o servidor TOMCAT, porém não sei o
		// // motivo está retornando a hora de fuso horário (timezone) diferente
		Date data = new Date();
		//
		// // formatador de data do tipo Date, onde os parametros yyyy, MM, etc,
		// // são identificadores definidos na classe, então para outras
		// // formatações, é necessário verificar a documentação da classe
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//
		// // timezone define um timezone para a classe Calendar, como está meio
		// // que com bug o TOMCAT, utilizei outra forma de recuperar a data que
		// // preciso
		TimeZone timeZone = TimeZone.getTimeZone("America/Recife");
		Calendar c1 = Calendar.getInstance(timeZone);
		c1.setTimeZone(timeZone);
		//
		// // criando Date utilizei os metodos decripitadors, porque foi a única
		// // maneira que encontrei de recuperar a data para ser formatada pelo
		// // SimpleDateFormat, uma vez que usando c1.getTime não estava
		// retonando
		// // o novo timezone que define em 72.
		data = c1.getTime();
		data.setHours(c1.get(Calendar.HOUR_OF_DAY));
		data.setMinutes(c1.get(Calendar.MINUTE));
		data.setSeconds(c1.get(Calendar.SECOND));
		String dataFormatada = formatDate.format(data);

		ramalTemp = (Ramal) event.getObject();

//		log.setFoneRamal(ramalTemp.getFone());
		log.setData(dataFormatada);
		log.setUsuario("");
		log.setCategoriaOld(ramalTemp.getCategoria());
		log.setTipoDeRamalOld(ramalTemp.getTipoDeRamal());
		log.setLocalOld(ramalTemp.getLocal());
		log.setObservacoesOld(ramalTemp.getObservacoes());
	}

}
