package br.jus.tjpe.infosistelecom.factory;

import br.jus.tjpe.infosistelecom.dao.FotoDao;
import br.jus.tjpe.infosistelecom.dao.jdbc.JDBCFotoDao;

public class FotoDaoFactory {
	
	public static FotoDao createFotoDao(){
		
		FotoDao fotoDao = new JDBCFotoDao();
		
		return fotoDao;
	}

}
