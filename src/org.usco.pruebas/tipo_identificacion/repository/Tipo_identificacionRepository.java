package org.usco.pruebas.tipo_identificacion;


import java.util.List;

public interface Tipo_identificacionRepository {
	
	public int create (Tipo_identificacion tipo_identificacion);
	
	public List<Tipo_identificacion> read ();
	
	public int update (int id, Tipo_identificacion tipo_identificacion);
	
	public int delete (int id);

}
