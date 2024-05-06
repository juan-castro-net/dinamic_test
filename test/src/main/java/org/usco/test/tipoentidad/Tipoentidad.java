package org.usco.test.tipoentidad;

import java.sql.Timestamp;
import java.sql.Date;


public class Tipoentidad {
    private int id;
	private String nombre;
	private int estado;

	
	public Tipoentidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipoentidad(int id, String nombre, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;

	}

	public Tipoentidad(String nombre, int estado) {
		super();
		this.nombre = nombre;
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
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Tipoentidad [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
