package org.usco.agro.metodo;


import java.util.List;

public interface MetodoRepository {
	
	public int create (Metodo metodo);
	
	public List<Metodo> read ();
	
	public int update (int id, Metodo metodo);
	
	public int delete (int id);

}
