package org.usco.agro.tipo_produccion;


import java.util.List;

public interface Tipo_produccionRepository {
	
	public int create (Tipo_produccion tipo_produccion);
	
	public List<Tipo_produccion> read ();
	
	public int update (int id, Tipo_produccion tipo_produccion);
	
	public int delete (int id);

}
