package org.usco.pruebas.modulo;


import java.util.List;

public interface ModuloRepository {
	
	public int create (Modulo modulo);
	
	public List<Modulo> read ();
	
	public int update (int id, Modulo modulo);
	
	public int delete (int id);

}
