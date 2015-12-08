package br.jus.tjpe.infosistelecom.dao;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.modelo.Tecnico;

public interface TecnicoDao {

	public ArrayList<Tecnico> listarTudo();

	public void adicionar(Tecnico t);

	public void remover(Tecnico t);

	public void atualizar(Tecnico t);
	
	public Tecnico buscar(Tecnico t);
	
	public Tecnico buscarPorEmail(String login);
}
