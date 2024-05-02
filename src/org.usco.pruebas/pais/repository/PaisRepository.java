package org.usco.pruebas.pais;


import java.util.List;

public interface PaisRepository {
	
	public int create (Pais pais);
	
	public List<Pais> read ();
	
	public int update (int id, Pais pais);
	
	public int delete (int id);

}
