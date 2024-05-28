package org.usco.agro.producto_presentacion;

import java.sql.Timestamp;
import java.sql.Date;


public class Producto_presentacion {
    private int id;
	private int producto_id;
	private String nombre;
	private String descripcion;
	private int estado;

	
	public Producto_presentacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto_presentacion(int id, int producto_id, String nombre, String descripcion, int estado) {
		super();
		this.id = id;
		this.producto_id = producto_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Producto_presentacion(int producto_id, String nombre, String descripcion, int estado) {
		super();
		this.producto_id = producto_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Producto_presentacion [id=" + id + ", producto_id=" + producto_id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
