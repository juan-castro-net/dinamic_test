package org.usco.pruebas.estado;


import java.util.List;

public interface EstadoRepository {
	
	public int create (Estado estado);
	
	public List<Estado> read ();
	
	public int update (int id, Estado estado);
	
	public int delete (int id);

}
