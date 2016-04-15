package br.jus.tjpe.infosistelecom.dao;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.modelo.Orgao;


public interface OrgaoDao {
	
	public ArrayList<Orgao> listarTudo();
	
	public ArrayList<String> listarCidades();
	
	public ArrayList<Orgao> listarOrgaosPorCidade(String cidade);

	public void adicionar(Orgao c);

	public void remover(Orgao c);

	public void atualizar(Orgao c);
	
	public Orgao buscar(String nomeOrgao);


}
