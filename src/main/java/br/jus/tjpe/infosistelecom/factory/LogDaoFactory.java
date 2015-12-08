package br.jus.tjpe.infosistelecom.factory;

import br.jus.tjpe.infosistelecom.dao.LogDao;
import br.jus.tjpe.infosistelecom.dao.jdbc.JDBCLogDao;

public class LogDaoFactory {
	
	public static LogDao createLogDaoFactory(){
		
		LogDao logDao = new JDBCLogDao();
		
		return logDao;
	}

}
