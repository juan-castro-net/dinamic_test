package org.usco.agro.tipo_espacio;


import java.util.List;

public interface Tipo_espacioRepository {
	
	public int create (Tipo_espacio tipo_espacio);
	
	public List<Tipo_espacio> read ();
	
	public int update (int id, Tipo_espacio tipo_espacio);
	
	public int delete (int id);

}
