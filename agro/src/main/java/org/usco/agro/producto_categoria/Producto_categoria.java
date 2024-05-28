package org.usco.agro.producto_categoria;

import java.sql.Timestamp;
import java.sql.Date;


public class Producto_categoria {
    private int id;
	private String nombre;
	private String descripcion;
	private int estado;

	
	public Producto_categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto_categoria(int id, String nombre, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Producto_categoria(String nombre, String descripcion, int estado) {
		super();
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
		return "Producto_categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
