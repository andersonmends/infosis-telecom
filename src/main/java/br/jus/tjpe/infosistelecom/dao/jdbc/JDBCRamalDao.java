package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

public class JDBCRamalDao implements RamalDao {

	private Connection con;

	public JDBCRamalDao() {

		con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Ramal> listarTudo() {
		ArrayList<Ramal> ramais = new ArrayList<Ramal>();

		try {
			PreparedStatement prst = con
					.prepareStatement("select distinct * from RAMAL, ORGAO where PK_ORGAO_CentroDeCusto = FK_ORGAO_RAMAL_CentroDeCusto");
			ResultSet rs = prst.executeQuery();

			while (rs.next()) {
				Ramal r = new Ramal();
				Orgao o = new Orgao();

				// recuperação da tabela órgão
				o.setCentroDeCusto(rs.getString("FK_ORGAO_RAMAL_CentroDeCusto"));
				o.setUnidade(rs.getString("ORGAO_NM_Unidade"));
				o.setPredio(rs.getString("ORGAO_NM_Predio"));
				o.setPolo(rs.getString("ORGAO_NM_Polo"));
				o.setCidade(rs.getString("ORGAO_NM_Cidade"));
				o.setEndereco(rs.getString("ORGAO_NM_Endereco"));

				// recuperação da tabela ramal

				r.setFone(Long.toString(rs.getLong("PK_RAMAL_Fone")));
				r.setCircuito(rs.getString("RAMAL_ID_Circuito"));
				r.setSituacao(rs.getString("RAMAL_ST_Situacao"));
				r.setCategoria(rs.getString("RAMAL_ST_Categoria"));
				r.setTipoDeRamal(rs.getString("RAMAL_ST_TipoDeRamal"));
				r.setOrgao(o);
				r.setUnidade(rs.getString("RAMAL_NM_Unidade"));
				r.setLocal(rs.getString("RAMAL_NM_Local"));
				
//				r.setDataDeAtivacao(rs.getString("RAMAL_DT_DataDeAtivacao"));
				r.setObservacoes(rs.getString("RAMAL_DS_Observacoes"));
				r.setCentroDeCusto(rs.getString("FK_ORGAO_RAMAL_CentroDeCusto"));

				ramais.add(r);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ramais;
	}

	@Override
	public void adicionar(Ramal r) {

		try {
			PreparedStatement prst = con
					.prepareStatement("INSERT INTO RAMAL VALUES (?,?,?,?,?,?,?,?,?) ");
			
			prst.setLong(1, Long.parseLong(r.getFone()));
			prst.setString(2, r.getCircuito());
			prst.setString(3, r.getSituacao());
			prst.setString(4, r.getCategoria());
			prst.setString(5, r.getTipoDeRamal());
			prst.setString(6, r.getOrgao().getUnidade());
			prst.setString(7, r.getLocal());
//			prst.setString(10, r.getDataDeAtivacao());
			prst.setString(12, r.getObservacoes());
			prst.setString(8,r.getOrgao().getCentroDeCusto());
			prst.execute();
			prst.close();

			System.out.println("insert Successfully!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Ramal r) {

		try {
			PreparedStatement prst = con
					.prepareStatement("DELETE FROM RAMAL WHERE PK_RAMAL_Fone = ?");

			prst.setLong(1, Long.parseLong(r.getFone()));
			prst.execute();
			prst.close();

			System.out.println("Ramal removido com successo!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Ramal r) {

		try {
			PreparedStatement prst = con.prepareStatement("update RAMAL set "
					+ "RAMAL_ID_Circuito = ? , " 
					+ "RAMAL_ST_Situacao = ? , "
					+ "RAMAL_ST_Categoria = ? , "
					+ "RAMAL_ST_TipoDeRamal = ?, "
					+ "RAMAL_NM_Unidade = ?, "
					+ "RAMAL_NM_Local = ?, "
//					+ "RAMAL_DT_DataDeAtivacao = ?, "
					+ "RAMAL_DS_Observacoes = ?, "
					+ "FK_ORGAO_RAMAL_CentroDeCusto = ? "
					+ "where PK_RAMAL_Fone = ?");
			prst.setString(1, r.getCircuito());
			prst.setString(2, r.getSituacao());
			prst.setString(3, r.getCategoria());
			prst.setString(4, r.getTipoDeRamal());
			prst.setString(5, r.getOrgao().getUnidade());
			prst.setString(6, r.getLocal());
//			prst.setString(9, r.getDataDeAtivacao());
			prst.setString(7, r.getObservacoes());
			prst.setString(8, r.getOrgao().getCentroDeCusto());
			prst.setLong(9, Long.parseLong(r.getFone()));
			prst.executeUpdate();
			prst.close();

			System.out.println("Updated Successfully! RAMAL JDBC");

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	@Override
	public Ramal buscarPorNumero(int a) {

		return null;
	}

	@Override
	public ArrayList<Ramal> buscarTudoPorComarca(Orgao c) {
		return null;
	}

}
