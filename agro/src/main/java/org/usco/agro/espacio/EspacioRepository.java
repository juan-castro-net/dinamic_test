package org.usco.agro.espacio;


import java.util.List;

public interface EspacioRepository {
	
	public int create (Espacio espacio);
	
	public List<Espacio> read ();
	
	public int update (int id, Espacio espacio);
	
	public int delete (int id);

}
