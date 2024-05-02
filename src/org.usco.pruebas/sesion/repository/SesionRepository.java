package org.usco.pruebas.sesion;


import java.util.List;

public interface SesionRepository {
	
	public int create (Sesion sesion);
	
	public List<Sesion> read ();
	
	public int update (int id, Sesion sesion);
	
	public int delete (int id);

}
