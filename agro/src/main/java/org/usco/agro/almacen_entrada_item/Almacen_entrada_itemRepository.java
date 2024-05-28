package org.usco.agro.almacen_entrada_item;


import java.util.List;

public interface Almacen_entrada_itemRepository {
	
	public int create (Almacen_entrada_item almacen_entrada_item);
	
	public List<Almacen_entrada_item> read ();
	
	public int update (int id, Almacen_entrada_item almacen_entrada_item);
	
	public int delete (int id);

}
