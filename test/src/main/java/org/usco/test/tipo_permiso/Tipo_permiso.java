package org.usco.test.tipo_permiso;

import java.sql.Timestamp;
import java.sql.Date;


public class Tipo_permiso {
    private int id;
	private String nombre;

	
	public Tipo_permiso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_permiso(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;

	}

	public Tipo_permiso(String nombre) {
		super();
		this.nombre = nombre;

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

    
	@Override
	public String toString() {
		return "Tipo_permiso [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
