package org.usco.pruebas.tipo_permiso;


import java.util.List;

public interface Tipo_permisoRepository {
	
	public int create (Tipo_permiso tipo_permiso);
	
	public List<Tipo_permiso> read ();
	
	public int update (int id, Tipo_permiso tipo_permiso);
	
	public int delete (int id);

}
