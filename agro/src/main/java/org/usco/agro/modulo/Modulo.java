package org.usco.agro.modulo;

import java.sql.Timestamp;
import java.sql.Date;


public class Modulo {
    private int id;
	private String nombre;
	private String url;
	private String descripcion;
	private int estado;

	
	public Modulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modulo(int id, String nombre, String url, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Modulo(String nombre, String url, String descripcion, int estado) {
		super();
		this.nombre = nombre;
		this.url = url;
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
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		return "Modulo [id=" + id + ", nombre=" + nombre + ", url=" + url + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
