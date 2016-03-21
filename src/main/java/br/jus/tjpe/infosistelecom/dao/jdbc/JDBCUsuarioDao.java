package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.jus.tjpe.infosistelecom.dao.UsuarioDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Usuario;

public class JDBCUsuarioDao implements UsuarioDao {
	
	private Connection con;
	
	public JDBCUsuarioDao(){
		
		this.con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Usuario> listarTudo() {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			PreparedStatement prst = con.prepareStatement("SELECT * FROM usuario");
			
			ResultSet rs = prst.executeQuery();
			
			while(rs.next()){
				
				Usuario usuario = new Usuario();
				usuario.setMatricula(Long.toString(rs.getLong("PK_USUARIO_Matricula")));
				usuario.setLogin(rs.getString("USUARIO_NM_Login"));
				usuario.setPermissao(Long.toString(rs.getLong("USUARIO_ST_Permissao")));
				usuarios.add(usuario);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
	}

	@Override
	public void adicionar(Usuario t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Usuario t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Usuario t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario buscar(Usuario t) {
		Usuario usuarioTemp = new Usuario();
		try {
			PreparedStatement prst = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO_NM_Login =?");
			
			prst.setString(1, t.getLogin());
			ResultSet rs =prst.executeQuery();
			
			while (rs.next()) {
				
				usuarioTemp.setMatricula(Long.toString(rs.getLong("PK_USUARIO_Matricula")));
				usuarioTemp.setLogin(rs.getString("USUARIO_NM_Login"));
				usuarioTemp.setPermissao(Long.toString(rs.getLong("USUARIO_ST_Permissao")));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarioTemp;
	}

	
}
