package org.usco.agro.almacen_salida;


import java.util.List;

public interface Almacen_salidaRepository {
	
	public int create (Almacen_salida almacen_salida);
	
	public List<Almacen_salida> read ();
	
	public int update (int id, Almacen_salida almacen_salida);
	
	public int delete (int id);

}
