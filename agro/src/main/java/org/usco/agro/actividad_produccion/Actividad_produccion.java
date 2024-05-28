package org.usco.agro.actividad_produccion;

import java.sql.Timestamp;
import java.sql.Date;


public class Actividad_produccion {
    private int id;
	private String nombre;
	private int actividad_programacion_id;
	private String descripcion;
	private int estado;

	
	public Actividad_produccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actividad_produccion(int id, String nombre, int actividad_programacion_id, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.actividad_programacion_id = actividad_programacion_id;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Actividad_produccion(String nombre, int actividad_programacion_id, String descripcion, int estado) {
		super();
		this.nombre = nombre;
		this.actividad_programacion_id = actividad_programacion_id;
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
	public int getActividad_programacion_id() {
		return actividad_programacion_id;
	}

	public void setActividad_programacion_id(int actividad_programacion_id) {
		this.actividad_programacion_id = actividad_programacion_id;
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
		return "Actividad_produccion [id=" + id + ", nombre=" + nombre + ", actividad_programacion_id=" + actividad_programacion_id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
