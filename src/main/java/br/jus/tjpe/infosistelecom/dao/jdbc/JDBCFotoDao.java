package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.dao.FotoDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Comarca;
import br.jus.tjpe.infosistelecom.modelo.Foto;

public class JDBCFotoDao implements FotoDao {

	private Connection con = ConnectionFactory.getConnection();

	public JDBCFotoDao() {

		con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Foto> listarTudo(Comarca c) {

		ArrayList<Foto> fotos = new ArrayList<Foto>();

		try {
			PreparedStatement prst = con
					.prepareStatement("SELECT * FROM FOTO WHERE FT_NM_Comarca LIKE '"
							+ c.getCidade()+"'");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				Foto foto = new Foto();
				foto.setComarca(rs.getString(("FT_NM_Comarca")));
				foto.setNome(rs.getString(("FT_NM_Nome")));
				foto.setEndereco(rs.getString(("FT_DS_Endereco")));
				foto.setTamanho(rs.getLong(("FT_NU_Tamanho")));
				foto.setTipo(rs.getString(("FT_CH_Tipo")));

				fotos.add(foto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fotos;
	}

	@Override
	public void adicionar(Foto f) {

		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO FOTO values (null,?,?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEndereco());
			stmt.setLong(3, f.getTamanho());
			stmt.setString(4, f.getTipo());
			stmt.setString(5, f.getComarca());

			stmt.execute();
			stmt.close();

			System.out.print("Inserido");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(Foto f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Foto f) {
		// TODO Auto-generated method stub

	}

}
