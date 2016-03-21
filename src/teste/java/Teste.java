import java.util.ArrayList;
import java.util.Iterator;

import br.jus.tjpe.infosistelecom.dao.ComarcaDao;
import br.jus.tjpe.infosistelecom.dao.FotoDao;
import br.jus.tjpe.infosistelecom.dao.UsuarioDao;
import br.jus.tjpe.infosistelecom.factory.ComarcaDaoFactory;
import br.jus.tjpe.infosistelecom.factory.FotoDaoFactory;
import br.jus.tjpe.infosistelecom.factory.UsuarioDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Comarca;
import br.jus.tjpe.infosistelecom.modelo.Foto;
import br.jus.tjpe.infosistelecom.modelo.Usuario;

public class Teste {

	public static void main(String[] args) {

		
//		Comarca c = new Comarca();
//		c.setCidade("Agrestina");
//		FotoDao dao = FotoDaoFactory.createFotoDao();
//		ArrayList<Foto> fotos = dao.listarTudo(c);
//		
//		System.out.println(fotos.get(0).getComarca());
//		System.out.println(fotos.get(0).getNome());
//		System.out.println(fotos.get(0).getEndereco());
		
		Usuario t = new Usuario();
		t.setLogin("amesantos");

		
		UsuarioDao dao = UsuarioDaoFactory.createUsuarioDao();
		Usuario temp = dao.buscar(t);
		
		System.out.println(temp.getLogin());
		System.out.println(temp.getMatricula());



	}
}