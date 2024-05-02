package org.usco.pruebas.tipo_identificacion;

import java.sql.Timestamp;
import java.sql.Date;


public class Tipo_identificacion {
    private int id;
	private String nombre;

	
	public Tipo_identificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_identificacion(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;

	}

	public Tipo_identificacion(String nombre) {
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
		return "Tipo_identificacion [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
