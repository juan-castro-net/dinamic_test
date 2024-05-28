package org.usco.agro.actividad_ocupacion;

import java.sql.Timestamp;
import java.sql.Date;


public class Actividad_ocupacion {
    private int id;
	private String nombre;
	private int tipo_actividad_id;
	private int evaluacion;

	
	public Actividad_ocupacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actividad_ocupacion(int id, String nombre, int tipo_actividad_id, int evaluacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo_actividad_id = tipo_actividad_id;
		this.evaluacion = evaluacion;

	}

	public Actividad_ocupacion(String nombre, int tipo_actividad_id, int evaluacion) {
		super();
		this.nombre = nombre;
		this.tipo_actividad_id = tipo_actividad_id;
		this.evaluacion = evaluacion;

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
	public int getTipo_actividad_id() {
		return tipo_actividad_id;
	}

	public void setTipo_actividad_id(int tipo_actividad_id) {
		this.tipo_actividad_id = tipo_actividad_id;
	}
	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

    
	@Override
	public String toString() {
		return "Actividad_ocupacion [id=" + id + ", nombre=" + nombre + ", tipo_actividad_id=" + tipo_actividad_id + ", evaluacion=" + evaluacion + "]";
	}
	
}
