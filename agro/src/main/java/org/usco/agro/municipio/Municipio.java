package org.usco.agro.municipio;

import java.sql.Timestamp;
import java.sql.Date;


public class Municipio {
    private int id;
	private String nombre;
	private int departamento_id;
	private int codigo;
	private String acronimo;

	
	public Municipio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Municipio(int id, String nombre, int departamento_id, int codigo, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento_id = departamento_id;
		this.codigo = codigo;
		this.acronimo = acronimo;

	}

	public Municipio(String nombre, int departamento_id, int codigo, String acronimo) {
		super();
		this.nombre = nombre;
		this.departamento_id = departamento_id;
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
	public int getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(int departamento_id) {
		this.departamento_id = departamento_id;
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
		return "Municipio [id=" + id + ", nombre=" + nombre + ", departamento_id=" + departamento_id + ", codigo=" + codigo + ", acronimo=" + acronimo + "]";
	}
	
}
