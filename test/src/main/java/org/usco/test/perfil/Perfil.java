package org.usco.test.perfil;

import java.sql.Timestamp;
import java.sql.Date;


public class Perfil {
    private int id;
	private String nombre;
	private String descripcion;
	private int estado;
	private String codigo;

	
	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perfil(int id, String nombre, String descripcion, int estado, String codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.codigo = codigo;

	}

	public Perfil(String nombre, String descripcion, int estado, String codigo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.codigo = codigo;

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
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

    
	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + ", codigo=" + codigo + "]";
	}
	
}
