package org.usco.pruebas.estado;

import java.sql.Timestamp;
import java.sql.Date;


public class Estado {
    private int id;
	private String nombre;
	private String descripcion;

	
	public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estado(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;

	}

	public Estado(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;

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

    
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
