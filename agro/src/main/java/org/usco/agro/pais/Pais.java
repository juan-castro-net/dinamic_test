package org.usco.agro.pais;

import java.sql.Timestamp;
import java.sql.Date;


public class Pais {
    private int id;
	private String nombre;
	private int codigo;
	private String acronimo;

	
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pais(int id, String nombre, int codigo, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.acronimo = acronimo;

	}

	public Pais(String nombre, int codigo, String acronimo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.acronimo = acronimo;

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
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

    
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", acronimo=" + acronimo + "]";
	}
	
}
