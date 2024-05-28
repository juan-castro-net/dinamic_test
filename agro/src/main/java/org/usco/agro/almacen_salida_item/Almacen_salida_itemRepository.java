package org.usco.agro.almacen_salida_item;


import java.util.List;

public interface Almacen_salida_itemRepository {
	
	public int create (Almacen_salida_item almacen_salida_item);
	
	public List<Almacen_salida_item> read ();
	
	public int update (int id, Almacen_salida_item almacen_salida_item);
	
	public int delete (int id);

}
