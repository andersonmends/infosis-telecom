package br.jus.tjpe.infosistelecom.factory;


import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.dao.jdbc.JDBCRamalDao;

public class RamalDaoFactory {

	public static RamalDao createRamalDao() {

		RamalDao ramalDao = new JDBCRamalDao();

		return ramalDao;
	}

}
