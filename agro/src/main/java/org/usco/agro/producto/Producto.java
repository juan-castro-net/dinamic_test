package org.usco.agro.producto;

import java.sql.Timestamp;
import java.sql.Date;


public class Producto {
    private int id;
	private String nombre;
	private int producto_categoria_id;

	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String nombre, int producto_categoria_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.producto_categoria_id = producto_categoria_id;

	}

	public Producto(String nombre, int producto_categoria_id) {
		super();
		this.nombre = nombre;
		this.producto_categoria_id = producto_categoria_id;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProducto_categoria_id() {
		return producto_categoria_id;
	}

	public void setProducto_categoria_id(int producto_categoria_id) {
		this.producto_categoria_id = producto_categoria_id;
	}

    
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", producto_categoria_id=" + producto_categoria_id + "]";
	}
	
}
