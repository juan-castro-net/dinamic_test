package org.usco.agro.tipo_produccion_proceso;


import java.util.List;

public interface Tipo_produccion_procesoRepository {
	
	public int create (Tipo_produccion_proceso tipo_produccion_proceso);
	
	public List<Tipo_produccion_proceso> read ();
	
	public int update (int id, Tipo_produccion_proceso tipo_produccion_proceso);
	
	public int delete (int id);

}
