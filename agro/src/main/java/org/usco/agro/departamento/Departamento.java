package org.usco.agro.departamento;

import java.sql.Timestamp;
import java.sql.Date;


public class Departamento {
    private int id;
	private String nombre;
	private int pais_id;
	private int codigo;
	private String acronimo;

	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departamento(int id, String nombre, int pais_id, int codigo, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais_id = pais_id;
		this.codigo = codigo;
		this.acronimo = acronimo;

	}

	public Departamento(String nombre, int pais_id, int codigo, String acronimo) {
		super();
		this.nombre = nombre;
		this.pais_id = pais_id;
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
	public int getPais_id() {
		return pais_id;
	}

	public void setPais_id(int pais_id) {
		this.pais_id = pais_id;
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
		return "Departamento [id=" + id + ", nombre=" + nombre + ", pais_id=" + pais_id + ", codigo=" + codigo + ", acronimo=" + acronimo + "]";
	}
	
}
