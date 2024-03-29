package br.jus.tjpe.infosistelecom.dao;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.modelo.Comarca;
import br.jus.tjpe.infosistelecom.modelo.Usuario;

public interface ComarcaDao {
	
	public ArrayList<Comarca> listarTudo();

	public void adicionar(Comarca c);

	public void remover(Comarca c);

	public void atualizar(Comarca c);
	
	public Usuario buscar(Comarca c);


}
