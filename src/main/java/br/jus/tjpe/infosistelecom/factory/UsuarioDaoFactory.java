package br.jus.tjpe.infosistelecom.factory;

import br.jus.tjpe.infosistelecom.dao.UsuarioDao;
import br.jus.tjpe.infosistelecom.dao.jdbc.JDBCUsuarioDao;

public class UsuarioDaoFactory {

	public static UsuarioDao createUsuarioDao() {

		UsuarioDao usuario = new JDBCUsuarioDao();

		return usuario;
	}

}
