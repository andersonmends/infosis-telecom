package br.jus.tjpe.infosistelecom.dao;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.modelo.Usuario;

public interface UsuarioDao {

	public ArrayList<Usuario> listarTudo();

	public void adicionar(Usuario t);

	public void remover(Usuario t);

	public void atualizar(Usuario t);
	
	public Usuario buscar(Usuario t);
	
}
