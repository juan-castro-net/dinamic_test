package org.usco.agro.modulo_metodo;

import java.sql.Timestamp;
import java.sql.Date;


public class Modulo_metodo {
    private int id;
	private int modulo_id;
	private int metodo_id;
	private String uri;
	private int estado;

	
	public Modulo_metodo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modulo_metodo(int id, int modulo_id, int metodo_id, String uri, int estado) {
		super();
		this.id = id;
		this.modulo_id = modulo_id;
		this.metodo_id = metodo_id;
		this.uri = uri;
		this.estado = estado;

	}

	public Modulo_metodo(int modulo_id, int metodo_id, String uri, int estado) {
		super();
		this.modulo_id = modulo_id;
		this.metodo_id = metodo_id;
		this.uri = uri;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getModulo_id() {
		return modulo_id;
	}

	public void setModulo_id(int modulo_id) {
		this.modulo_id = modulo_id;
	}
	public int getMetodo_id() {
		return metodo_id;
	}

	public void setMetodo_id(int metodo_id) {
		this.metodo_id = metodo_id;
	}
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Modulo_metodo [id=" + id + ", modulo_id=" + modulo_id + ", metodo_id=" + metodo_id + ", uri=" + uri + ", estado=" + estado + "]";
	}
	
}
