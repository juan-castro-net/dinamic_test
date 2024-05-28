package org.usco.agro.almacen_entrada;


import java.util.List;

public interface Almacen_entradaRepository {
	
	public int create (Almacen_entrada almacen_entrada);
	
	public List<Almacen_entrada> read ();
	
	public int update (int id, Almacen_entrada almacen_entrada);
	
	public int delete (int id);

}
