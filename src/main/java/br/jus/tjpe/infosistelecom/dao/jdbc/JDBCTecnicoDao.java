package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.jus.tjpe.infosistelecom.dao.TecnicoDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Tecnico;

public class JDBCTecnicoDao implements TecnicoDao {
	
	private Connection con;
	
	public JDBCTecnicoDao(){
		
		this.con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Tecnico> listarTudo() {
		
		ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
		
		try {
			PreparedStatement prst = con.prepareStatement("SELECT * FROM tecnico");
			
			ResultSet rs = prst.executeQuery();
			
			while(rs.next()){
				
				Tecnico tecnico = new Tecnico();
				tecnico.setNome(rs.getString("TEC_NM_Nome"));
				tecnico.setPolo(rs.getString("TEC_NM_Polo"));
				tecnicos.add(tecnico);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tecnicos;
	}

	@Override
	public void adicionar(Tecnico t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Tecnico t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Tecnico t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tecnico buscar(Tecnico t) {
		Tecnico tecnicoTemp = new Tecnico();
		try {
			PreparedStatement prst = con.prepareStatement("SELECT * FROM TECNICO WHERE TEC_VC_Login =?");
			
			prst.setString(1, t.getLogin());
			ResultSet rs =prst.executeQuery();
			
			while (rs.next()) {
				tecnicoTemp.setLogin(rs.getString("TEC_VC_Login"));
				tecnicoTemp.setSenha(rs.getString("TEC_VC_Senha"));
				tecnicoTemp.setNome(rs.getString("TEC_NM_Nome"));
				tecnicoTemp.setPolo(rs.getString("TEC_NM_Polo"));
				tecnicoTemp.setMatricula((int)rs.getLong("TEC_PK_Matricula"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tecnicoTemp;
	}

	@Override
	public Tecnico buscarPorEmail(String login) {
		Tecnico tecnicoTemp = new Tecnico();
		try {
			PreparedStatement prst = con.prepareStatement("SELECT * FROM TECNICO WHERE TEC_VC_Login =?");
			
			prst.setString(1, login);
			ResultSet rs =prst.executeQuery();
			
			while (rs.next()) {
				tecnicoTemp.setLogin(rs.getString("TEC_VC_Login"));
				tecnicoTemp.setSenha(rs.getString("TEC_VC_Senha"));
				tecnicoTemp.setNome(rs.getString("TEC_NM_Nome"));
				tecnicoTemp.setPolo(rs.getString("TEC_NM_Polo"));
				tecnicoTemp.setMatricula((int)rs.getLong("TEC_PK_Matricula"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tecnicoTemp;
	}

}
