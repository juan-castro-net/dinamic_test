package org.usco.test.modulo;

import java.sql.Timestamp;
import java.sql.Date;


public class Modulo {
    private int id;
	private String nombre;
	private String descripcion;
	private int estado;
	private String url;

	
	public Modulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modulo(int id, String nombre, String descripcion, int estado, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.url = url;

	}

	public Modulo(String nombre, String descripcion, int estado, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.url = url;

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
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    
	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + ", url=" + url + "]";
	}
	
}
