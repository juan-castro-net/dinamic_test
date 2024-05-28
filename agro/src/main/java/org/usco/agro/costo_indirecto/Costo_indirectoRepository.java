package org.usco.agro.costo_indirecto;


import java.util.List;

public interface Costo_indirectoRepository {
	
	public int create (Costo_indirecto costo_indirecto);
	
	public List<Costo_indirecto> read ();
	
	public int update (int id, Costo_indirecto costo_indirecto);
	
	public int delete (int id);

}
