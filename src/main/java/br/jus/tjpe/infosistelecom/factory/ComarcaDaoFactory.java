package br.jus.tjpe.infosistelecom.factory;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.dao.ComarcaDao;
import br.jus.tjpe.infosistelecom.dao.jdbc.JDBCComarcaDao;


public class ComarcaDaoFactory {

	public static ComarcaDao createComarcaDao() {

		ComarcaDao comarca = new JDBCComarcaDao();
		return comarca;
	}

}
