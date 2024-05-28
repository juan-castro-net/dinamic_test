package org.usco.agro.producto_categoria;


import java.util.List;

public interface Producto_categoriaRepository {
	
	public int create (Producto_categoria producto_categoria);
	
	public List<Producto_categoria> read ();
	
	public int update (int id, Producto_categoria producto_categoria);
	
	public int delete (int id);

}
