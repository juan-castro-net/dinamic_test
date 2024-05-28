package org.usco.agro.tipo_espacio;

import java.sql.Timestamp;
import java.sql.Date;


public class Tipo_espacio {
    private int id;
	private String nombre;
	private String descripcion;
	private int estado;

	
	public Tipo_espacio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_espacio(int id, String nombre, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Tipo_espacio(String nombre, String descripcion, int estado) {
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
		return "Tipo_espacio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
