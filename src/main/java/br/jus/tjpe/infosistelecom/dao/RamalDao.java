package br.jus.tjpe.infosistelecom.dao;

import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

import java.util.ArrayList;


public interface RamalDao {
	
	public ArrayList<Ramal> listarTudo();
	

	public void adicionar(Ramal r);

	public void remover(Ramal r);

	public void atualizar(Ramal r);
	
	public Ramal buscarPorNumero(int a);
	
	public ArrayList<Ramal> buscarTudoPorComarca (Orgao c);

}
