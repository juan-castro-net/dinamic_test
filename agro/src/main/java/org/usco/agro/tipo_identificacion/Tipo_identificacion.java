package org.usco.agro.tipo_identificacion;

import java.sql.Timestamp;
import java.sql.Date;


public class Tipo_identificacion {
    private int id;
	private String nombre;
	private String descripcion;
	private int estado_id;

	
	public Tipo_identificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_identificacion(int id, String nombre, String descripcion, int estado_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado_id = estado_id;

	}

	public Tipo_identificacion(String nombre, String descripcion, int estado_id) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado_id = estado_id;

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
	public int getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(int estado_id) {
		this.estado_id = estado_id;
	}

    
	@Override
	public String toString() {
		return "Tipo_identificacion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado_id=" + estado_id + "]";
	}
	
}
