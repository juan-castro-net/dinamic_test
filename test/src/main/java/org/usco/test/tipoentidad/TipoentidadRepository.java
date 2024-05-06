package org.usco.test.tipoentidad;


import java.util.List;

public interface TipoentidadRepository {
	
	public int create (Tipoentidad tipoentidad);
	
	public List<Tipoentidad> read ();
	
	public int update (int id, Tipoentidad tipoentidad);
	
	public int delete (int id);

}
