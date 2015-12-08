package br.jus.tjpe.infosistelecom.factory;

import br.jus.tjpe.infosistelecom.dao.TecnicoDao;
import br.jus.tjpe.infosistelecom.dao.jdbc.JDBCTecnicoDao;

public class TecnicoDaoFactory {

	public static TecnicoDao createTecnicoDao() {

		TecnicoDao tecnico = new JDBCTecnicoDao();

		return tecnico;
	}

}
