package org.usco.agro.proveedor;


import java.util.List;

public interface ProveedorRepository {
	
	public int create (Proveedor proveedor);
	
	public List<Proveedor> read ();
	
	public int update (int id, Proveedor proveedor);
	
	public int delete (int id);

}
