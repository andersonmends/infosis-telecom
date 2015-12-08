package br.jus.tjpe.infosistelecom.controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;

import br.jus.tjpe.infosistelecom.dao.FotoDao;
import br.jus.tjpe.infosistelecom.factory.FotoDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Comarca;
import br.jus.tjpe.infosistelecom.modelo.Foto;

@ManagedBean
@SessionScoped
public class UploadBean {

	public UploadBean() {

	}

	public void upload(FileUploadEvent evento) {

		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)contexto.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		Comarca comarca = (Comarca) session.getAttribute("comarca");

		Foto foto = new Foto();
		foto.setNome(evento.getFile().getFileName());
		foto.setTamanho(evento.getFile().getSize());
		foto.setTipo(evento.getFile().getContentType().substring(6));
		// o endereço aqui colocado é pq vai ser relativo ao contexto da aplicação, pois não tem como pegar o endereço físico do SO no contexto da aplicação
		// seria o Infosistelecom/ então adiciona o /fotos/ para a pasta onde ficarão, e essa pasta tem o link simbolico
		foto.setEndereco("/fotos/"+ comarca.getCidade()+"/"+ evento.getFile().getFileName());
		foto.setComarca(comarca.getCidade());

		// Pega o caminho de onda está sendo executado a aplicação, no caso do eclipse é:
		// C:\Users\Anderson Mendes\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\InfosisTelecom
		// No caso de usar o servidor tomcat será a pasta dele, EX: C:\tomcat\webapps
		File diretorio = new File(request.getRealPath("/fotos/" + comarca.getCidade()));
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		System.out.println(diretorio);

		FacesMessage message = new FacesMessage("Succesful", evento.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);

		// Faz o stream para gravar o arquivo em disco, no local indicado pelo caminho real do contexto da aplicação, que é o endereço físco da máquina
		// e esse endereço local tem link símblolico para a Unidade D, para poder garantir o armazenamento da foto independete de aplicação 
		try {
			InputStream entrada = evento.getFile().getInputstream();
			OutputStream saida = new FileOutputStream(new File(diretorio,
					evento.getFile().getFileName()));
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = entrada.read(bytes)) != -1) {
				saida.write(bytes, 0, read);
			}

			entrada.close();
			saida.flush();
			saida.close();
			
			FotoDao dao = FotoDaoFactory.createFotoDao();
			dao.adicionar(foto);
		} catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

	}

}
