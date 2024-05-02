package org.usco.pruebas.entidad;


import java.util.List;

public interface EntidadRepository {
	
	public int create (Entidad entidad);
	
	public List<Entidad> read ();
	
	public int update (int id, Entidad entidad);
	
	public int delete (int id);

}
