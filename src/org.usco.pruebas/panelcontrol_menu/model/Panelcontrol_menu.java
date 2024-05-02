package org.usco.pruebas.panelcontrol_menu;

import java.sql.Timestamp;
import java.sql.Date;


public class Panelcontrol_menu {
    private int id;
	private String nombre;

	
	public Panelcontrol_menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Panelcontrol_menu(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;

	}

	public Panelcontrol_menu(String nombre) {
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
		return "Panelcontrol_menu [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
