package org.usco.agro.tipo_actividad;


import java.util.List;

public interface Tipo_actividadRepository {
	
	public int create (Tipo_actividad tipo_actividad);
	
	public List<Tipo_actividad> read ();
	
	public int update (int id, Tipo_actividad tipo_actividad);
	
	public int delete (int id);

}
