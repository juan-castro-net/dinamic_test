package org.usco.agro.grupo;

import java.sql.Timestamp;
import java.sql.Date;


public class Grupo {
    private int id;
	private String nombre;
	private int empresa_id;
	private String descripcion;
	private int estado;

	
	public Grupo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grupo(int id, String nombre, int empresa_id, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empresa_id = empresa_id;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Grupo(String nombre, int empresa_id, String descripcion, int estado) {
		super();
		this.nombre = nombre;
		this.empresa_id = empresa_id;
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
	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
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
		return "Grupo [id=" + id + ", nombre=" + nombre + ", empresa_id=" + empresa_id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
