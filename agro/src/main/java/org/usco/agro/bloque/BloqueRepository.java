package org.usco.agro.bloque;


import java.util.List;

public interface BloqueRepository {
	
	public int create (Bloque bloque);
	
	public List<Bloque> read ();
	
	public int update (int id, Bloque bloque);
	
	public int delete (int id);

}
