package org.usco.pruebas.municipio;

import java.sql.Timestamp;
import java.sql.Date;


public class Municipio {
    private int id;
	private String nombre;
	private int departamento;
	private String codigo;
	private String acronimo;

	
	public Municipio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Municipio(int id, String nombre, int departamento, String codigo, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.codigo = codigo;
		this.acronimo = acronimo;

	}

	public Municipio(String nombre, int departamento, String codigo, String acronimo) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
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
	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
		return "Municipio [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", codigo=" + codigo + ", acronimo=" + acronimo + "]";
	}
	
}
