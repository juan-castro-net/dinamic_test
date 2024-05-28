package org.usco.agro.modulo_metodo;


import java.util.List;

public interface Modulo_metodoRepository {
	
	public int create (Modulo_metodo modulo_metodo);
	
	public List<Modulo_metodo> read ();
	
	public int update (int id, Modulo_metodo modulo_metodo);
	
	public int delete (int id);

}
