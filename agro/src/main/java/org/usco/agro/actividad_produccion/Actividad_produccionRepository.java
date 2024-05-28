package org.usco.agro.actividad_produccion;


import java.util.List;

public interface Actividad_produccionRepository {
	
	public int create (Actividad_produccion actividad_produccion);
	
	public List<Actividad_produccion> read ();
	
	public int update (int id, Actividad_produccion actividad_produccion);
	
	public int delete (int id);

}
