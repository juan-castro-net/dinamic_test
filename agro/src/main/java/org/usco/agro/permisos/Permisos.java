package org.usco.agro.permisos;

import java.sql.Timestamp;
import java.sql.Date;


public class Permisos {
    private int id;
	private int modulo_metodo_id;
	private String rol;
	private int metodo_id;

	
	public Permisos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permisos(int id, int modulo_metodo_id, String rol, int metodo_id) {
		super();
		this.id = id;
		this.modulo_metodo_id = modulo_metodo_id;
		this.rol = rol;
		this.metodo_id = metodo_id;

	}

	public Permisos(int modulo_metodo_id, String rol, int metodo_id) {
		super();
		this.modulo_metodo_id = modulo_metodo_id;
		this.rol = rol;
		this.metodo_id = metodo_id;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getModulo_metodo_id() {
		return modulo_metodo_id;
	}

	public void setModulo_metodo_id(int modulo_metodo_id) {
		this.modulo_metodo_id = modulo_metodo_id;
	}
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getMetodo_id() {
		return metodo_id;
	}

	public void setMetodo_id(int metodo_id) {
		this.metodo_id = metodo_id;
	}

    
	@Override
	public String toString() {
		return "Permisos [id=" + id + ", modulo_metodo_id=" + modulo_metodo_id + ", rol=" + rol + ", metodo_id=" + metodo_id + "]";
	}
	
}
