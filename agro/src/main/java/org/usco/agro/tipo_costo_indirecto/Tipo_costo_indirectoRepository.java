package org.usco.agro.tipo_costo_indirecto;


import java.util.List;

public interface Tipo_costo_indirectoRepository {
	
	public int create (Tipo_costo_indirecto tipo_costo_indirecto);
	
	public List<Tipo_costo_indirecto> read ();
	
	public int update (int id, Tipo_costo_indirecto tipo_costo_indirecto);
	
	public int delete (int id);

}
