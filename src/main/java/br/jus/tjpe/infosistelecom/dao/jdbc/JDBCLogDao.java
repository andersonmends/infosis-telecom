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
			PreparedStatement prst = con
					.prepareStatement("SELECT * FROM LOG ORDER BY PK_LOG_ID DESC LIMIT 10");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				Log log = new Log();
				log.setID(Long.toString(rs.getLong("PK_LOG_ID")));
				log.setData(rs.getString("LOG_DT_Data"));
				log.setUsuario(rs.getString("LOG_NM_Usuario"));
				log.setCategoriaDiurnaNew(rs
						.getString("LOG_ST_CategoriaDiurnaNew"));
				log.setCategoriaDiurnaOld(rs
						.getString("LOG_ST_CategoriaDiurnaOld"));
				log.setCategoriaNoturnaNew(rs
						.getString("LOG_ST_CategoriaNoturnaNew"));
				log.setCategoriaNoturnaOld(rs
						.getString("LOG_ST_CategoriaNoturnaOld"));
				log.setTipoDeRamalNew(rs.getString("LOG_ST_TipoDeRamalNew"));
				log.setTipoDeRamalOld(rs.getString("LOG_ST_TipoDeRamalOld"));
				log.setDivulgacaoNew(rs.getString("LOG_ST_DivulgacaoNew"));
				log.setDivulgacaoOld(rs.getString("LOG_ST_DivulgacaoOld"));
				log.setNomenclaturaNew(rs.getString("LOG_NM_NomenclaturaNew"));
				log.setNomenclaturaOld(rs.getString("LOG_NM_NomenclaturaOld"));
				log.setCompartilhadoComNew(rs
						.getString("LOG_DS_CompartilhadoComNew"));
				log.setCompartilhadoComOld(rs
						.getString("LOG_DS_CompartilhadoComOld"));
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
			PreparedStatement prst = con
					.prepareStatement("INSERT INTO LOG VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

			prst.setNull(1, 0);
			prst.setString(2, l.getData());
			prst.setString(3, l.getUsuario());
			prst.setString(4, l.getCategoriaDiurnaNew());
			prst.setString(5, l.getCategoriaDiurnaOld());
			prst.setString(6, l.getCategoriaNoturnaNew());
			prst.setString(7, l.getCategoriaNoturnaOld());
			prst.setString(8, l.getTipoDeRamalNew());
			prst.setString(9, l.getTipoDeRamalOld());
			prst.setString(10, l.getDivulgacaoNew());
			prst.setString(11, l.getDivulgacaoOld());
			prst.setString(12, l.getNomenclaturaNew());
			prst.setString(13, l.getNomenclaturaOld());
			prst.setString(14, l.getCompartilhadoComNew());
			prst.setString(15, l.getCompartilhadoComOld());
			prst.setString(16, l.getObservacoesNew());
			prst.setString(17, l.getObservacoesOld());
			prst.setLong(18, Long.parseLong(l.getFoneRamal()));
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
	public ArrayList<Log> pesquisa(String ramal, String inicio, String fim,
			String usuario) {
		ArrayList<Log> logs = new ArrayList<Log>();

		System.out.println(inicio);
		System.out.println(fim);

		try {
			PreparedStatement prst = con
					.prepareStatement("SELECT * FROM LOG WHERE FK_RAMAL_LOG_Fone like ? AND LOG_DT_Data BETWEEN ? AND ? AND LOG_NM_Usuario like ? ORDER BY LOG_DT_Data ASC");
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
				log.setCategoriaDiurnaNew(rs
						.getString("LOG_ST_CategoriaDiurnaNew"));
				log.setCategoriaDiurnaOld(rs
						.getString("LOG_ST_CategoriaDiurnaOld"));
				log.setCategoriaNoturnaNew(rs
						.getString("LOG_ST_CategoriaNoturnaNew"));
				log.setCategoriaNoturnaOld(rs
						.getString("LOG_ST_CategoriaNoturnaOld"));
				log.setTipoDeRamalNew(rs.getString("LOG_ST_TipoDeRamalNew"));
				log.setTipoDeRamalOld(rs.getString("LOG_ST_TipoDeRamalOld"));
				log.setDivulgacaoNew(rs.getString("LOG_ST_DivulgacaoNew"));
				log.setDivulgacaoOld(rs.getString("LOG_ST_DivulgacaoOld"));
				log.setNomenclaturaNew(rs.getString("LOG_NM_NomenclaturaNew"));
				log.setNomenclaturaOld(rs.getString("LOG_NM_NomenclaturaOld"));
				log.setCompartilhadoComNew(rs
						.getString("LOG_DS_CompartilhadoComNew"));
				log.setCompartilhadoComOld(rs
						.getString("LOG_DS_CompartilhadoComOld"));
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
