package org.usco.agro.proceso;

import java.sql.Timestamp;
import java.sql.Date;


public class Proceso {
    private int id;
	private int tipo_produccion_id;
	private String nombre;
	private String descripcion;
	private int estado;

	
	public Proceso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proceso(int id, int tipo_produccion_id, String nombre, String descripcion, int estado) {
		super();
		this.id = id;
		this.tipo_produccion_id = tipo_produccion_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Proceso(int tipo_produccion_id, String nombre, String descripcion, int estado) {
		super();
		this.tipo_produccion_id = tipo_produccion_id;
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
	public int getTipo_produccion_id() {
		return tipo_produccion_id;
	}

	public void setTipo_produccion_id(int tipo_produccion_id) {
		this.tipo_produccion_id = tipo_produccion_id;
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
		return "Proceso [id=" + id + ", tipo_produccion_id=" + tipo_produccion_id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
