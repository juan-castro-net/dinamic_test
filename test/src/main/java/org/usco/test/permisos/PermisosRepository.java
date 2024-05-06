package org.usco.test.permisos;


import java.util.List;

public interface PermisosRepository {
	
	public int create (Permisos permisos);
	
	public List<Permisos> read ();
	
	public int update (int id, Permisos permisos);
	
	public int delete (int id);

}
