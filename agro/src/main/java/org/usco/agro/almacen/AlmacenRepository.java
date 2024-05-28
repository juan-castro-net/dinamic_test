package org.usco.agro.almacen;


import java.util.List;

public interface AlmacenRepository {
	
	public int create (Almacen almacen);
	
	public List<Almacen> read ();
	
	public int update (int id, Almacen almacen);
	
	public int delete (int id);

}
