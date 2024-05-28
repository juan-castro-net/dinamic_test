package org.usco.agro.tipo_bloque;


import java.util.List;

public interface Tipo_bloqueRepository {
	
	public int create (Tipo_bloque tipo_bloque);
	
	public List<Tipo_bloque> read ();
	
	public int update (int id, Tipo_bloque tipo_bloque);
	
	public int delete (int id);

}
