package org.usco.agro.produccion;


import java.util.List;

public interface ProduccionRepository {
	
	public int create (Produccion produccion);
	
	public List<Produccion> read ();
	
	public int update (int id, Produccion produccion);
	
	public int delete (int id);

}
