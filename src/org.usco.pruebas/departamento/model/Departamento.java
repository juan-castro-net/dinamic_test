package org.usco.pruebas.departamento;

import java.sql.Timestamp;
import java.sql.Date;


public class Departamento {
    private int id;
	private String nombre;
	private int pais;
	private int codigo;
	private String acronimo;

	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departamento(int id, String nombre, int pais, int codigo, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.codigo = codigo;
		this.acronimo = acronimo;

	}

	public Departamento(String nombre, int pais, int codigo, String acronimo) {
		super();
		this.nombre = nombre;
		this.pais = pais;
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
	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
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
		return "Departamento [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", codigo=" + codigo + ", acronimo=" + acronimo + "]";
	}
	
}
