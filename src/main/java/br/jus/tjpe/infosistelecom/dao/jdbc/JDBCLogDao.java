package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.jus.tjpe.infosistelecom.dao.LogDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Log;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

public class JDBCLogDao implements LogDao {

	private Connection con;

	public JDBCLogDao() {

		con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Log> listarTudo() {

		ArrayList<Log> logs = new ArrayList<Log>();

		try {
			PreparedStatement prst = con.prepareStatement("SELECT * FROM LOG ORDER BY PK_LOG_ID DESC LIMIT 10");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				Log log = new Log();
				log.setID(Long.toString(rs.getLong("PK_LOG_ID")));
				log.setData(rs.getString("LOG_DT_Data"));
				log.setUsuario(rs.getString("LOG_NM_Usuario"));
				log.setCategoriaNew(rs.getString("LOG_ST_CategoriaNew"));
				log.setCategoriaOld(rs.getString("LOG_ST_CategoriaOld"));
				log.setTipoDeRamalNew(rs.getString("LOG_ST_TipoDeRamalNew"));
				log.setTipoDeRamalOld(rs.getString("LOG_ST_TipoDeRamalOld"));
				log.setLocalNew(rs.getString("LOG_NM_LocalNew"));
				log.setLocalOld(rs.getString("LOG_NM_LocalOld"));
				log.setObservacoesNew(rs.getString("LOG_DS_ObservacoesNew"));
				log.setObservacoesOld(rs.getString("LOG_DS_ObservacoesOld"));
				log.setFoneRamal(Long.toString(rs.getLong("FK_RAMAL_LOG_Fone")));
				logs.add(log);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Consulta realizado com sucesso");

		return logs;
	}

	@Override
	public void adicionar(Log l) {

		try {
			PreparedStatement prst = con.prepareStatement("INSERT INTO LOG VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ");

			prst.setNull(1, 0);
			prst.setString(2, l.getData());
			prst.setString(3, l.getUsuario());
			prst.setString(4, l.getCategoriaNew());
			prst.setString(5, l.getCategoriaOld());
			prst.setString(6, l.getTipoDeRamalNew());
			prst.setString(7, l.getTipoDeRamalOld());
			prst.setString(8, l.getLocalNew());
			prst.setString(9, l.getLocalOld());
			prst.setString(10, l.getObservacoesNew());
			prst.setString(11, l.getObservacoesOld());
			prst.setLong(12, Long.parseLong(l.getFoneRamal()));
			prst.execute();
			prst.close();

			System.out.println("insert Successfully! LOG");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void recuperarLogPorRamal(Ramal r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recuperarLogPorUsuario(String usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Log> pesquisa(String ramal, String inicio, String fim, String usuario) {
		ArrayList<Log> logs = new ArrayList<Log>();

		try {
			PreparedStatement prst = con.prepareStatement(
					"SELECT * FROM LOG WHERE FK_RAMAL_LOG_Fone like ? AND LOG_DT_Data BETWEEN ? AND ? AND LOG_NM_Usuario like ? ORDER BY LOG_DT_Data ASC");
			prst.setString(1, "%" + ramal + "%");
			prst.setString(2, inicio + " 00:00:00");
			prst.setString(3, fim + " 23:59:59");
			prst.setString(4, "%" + usuario + "%");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				Log log = new Log();
				log.setID(Long.toString(rs.getLong("PK_LOG_ID")));
				log.setData(rs.getString("LOG_DT_Data"));
				log.setUsuario(rs.getString("LOG_NM_Usuario"));
				log.setCategoriaNew(rs.getString("LOG_ST_CategoriaNew"));
				log.setCategoriaOld(rs.getString("LOG_ST_CategoriaOld"));
				log.setTipoDeRamalNew(rs.getString("LOG_ST_TipoDeRamalNew"));
				log.setTipoDeRamalOld(rs.getString("LOG_ST_TipoDeRamalOld"));
				log.setLocalNew(rs.getString("LOG_NM_LocalNew"));
				log.setLocalOld(rs.getString("LOG_NM_LocalOld"));
				log.setObservacoesNew(rs.getString("LOG_DS_ObservacoesNew"));
				log.setObservacoesOld(rs.getString("LOG_DS_ObservacoesOld"));
				log.setFoneRamal(Long.toString(rs.getLong("FK_RAMAL_LOG_Fone")));
				logs.add(log);
				// System.out.println(log.getData());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Consulta realizado com sucesso");

		return logs;
	}

}
