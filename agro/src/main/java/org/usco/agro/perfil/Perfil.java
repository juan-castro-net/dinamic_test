package org.usco.agro.perfil;

import java.sql.Timestamp;
import java.sql.Date;


public class Perfil {
    private int id;
	private String nombre;
	private String descripcion;
	private int estado;

	
	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perfil(int id, String nombre, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Perfil(String nombre, String descripcion, int estado) {
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
		return "Perfil [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
