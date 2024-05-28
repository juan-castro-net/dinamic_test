package org.usco.agro.tipo_actividad;

import java.sql.Timestamp;
import java.sql.Date;


public class Tipo_actividad {
    private int id;
	private int categoria_actividad_id;
	private int proceso_id;
	private String nombre;
	private String descripcion;
	private int estado;

	
	public Tipo_actividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_actividad(int id, int categoria_actividad_id, int proceso_id, String nombre, String descripcion, int estado) {
		super();
		this.id = id;
		this.categoria_actividad_id = categoria_actividad_id;
		this.proceso_id = proceso_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Tipo_actividad(int categoria_actividad_id, int proceso_id, String nombre, String descripcion, int estado) {
		super();
		this.categoria_actividad_id = categoria_actividad_id;
		this.proceso_id = proceso_id;
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
	public int getCategoria_actividad_id() {
		return categoria_actividad_id;
	}

	public void setCategoria_actividad_id(int categoria_actividad_id) {
		this.categoria_actividad_id = categoria_actividad_id;
	}
	public int getProceso_id() {
		return proceso_id;
	}

	public void setProceso_id(int proceso_id) {
		this.proceso_id = proceso_id;
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
		return "Tipo_actividad [id=" + id + ", categoria_actividad_id=" + categoria_actividad_id + ", proceso_id=" + proceso_id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
