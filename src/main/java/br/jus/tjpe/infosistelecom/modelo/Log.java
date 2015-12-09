package br.jus.tjpe.infosistelecom.modelo;

public class Log {

	private String ID;
	private String foneRamal;
	private String data;
	private String usuario;
	private String categoriaNew;
	private String categoriaOld;
	private String tipoDeRamalNew;
	private String tipoDeRamalOld;
	private String LocalNew;
	private String LocalOld;

	public String getLocalNew() {
		return LocalNew;
	}

	public void setLocalNew(String LocalNew) {
		this.LocalNew = LocalNew;
	}

	public String getLocalOld() {
		return LocalOld;
	}
	
	public void setLocalOld(String LocalOld) {
		this.LocalOld = LocalOld;
	}

	public String getCategoriaNew() {
		return categoriaNew;
	}

	public void setCategoriaNew(String categoriaNew) {
		this.categoriaNew = categoriaNew;
	}

	public String getCategoriaOld() {
		return categoriaOld;
	}

	public void setCategoriaOld(String categoriaOld) {
		this.categoriaOld = categoriaOld;
	}

	public String getTipoDeRamalNew() {
		return tipoDeRamalNew;
	}

	public void setTipoDeRamalNew(String tipoDeRamalNew) {
		this.tipoDeRamalNew = tipoDeRamalNew;
	}

	public String getTipoDeRamalOld() {
		return tipoDeRamalOld;
	}

	public void setTipoDeRamalOld(String tipoDeRamalOld) {
		this.tipoDeRamalOld = tipoDeRamalOld;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFoneRamal() {
		return foneRamal;
	}

	public void setFoneRamal(String foneRamal) {
		this.foneRamal = foneRamal;
	}

	public String getData() {
		return data.substring(0, 19);
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
