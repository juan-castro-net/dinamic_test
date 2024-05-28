package org.usco.agro.empresa;

import java.sql.Timestamp;
import java.sql.Date;


public class Empresa {
    private int id;
	private int tipo_identificacion_id;
	private String identificacion;
	private String nombre;
	private String descripcion;
	private int estado;

	
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empresa(int id, int tipo_identificacion_id, String identificacion, String nombre, String descripcion, int estado) {
		super();
		this.id = id;
		this.tipo_identificacion_id = tipo_identificacion_id;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Empresa(int tipo_identificacion_id, String identificacion, String nombre, String descripcion, int estado) {
		super();
		this.tipo_identificacion_id = tipo_identificacion_id;
		this.identificacion = identificacion;
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
	public int getTipo_identificacion_id() {
		return tipo_identificacion_id;
	}

	public void setTipo_identificacion_id(int tipo_identificacion_id) {
		this.tipo_identificacion_id = tipo_identificacion_id;
	}
	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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
		return "Empresa [id=" + id + ", tipo_identificacion_id=" + tipo_identificacion_id + ", identificacion=" + identificacion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
