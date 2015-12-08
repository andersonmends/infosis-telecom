package br.jus.tjpe.infosistelecom.factory;


import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.dao.jdbc.JDBCOrgaoDao;


public class OrgaoDaoFactory {

	public static OrgaoDao createOrgaoDao() {

		OrgaoDao comarca = new JDBCOrgaoDao();
		return comarca;
	}

}
