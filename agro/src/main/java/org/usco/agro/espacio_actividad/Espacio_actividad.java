package org.usco.agro.espacio_actividad;

import java.sql.Timestamp;
import java.sql.Date;


public class Espacio_actividad {
    private int id;
	private int espacio_id;
	private int tipo_actividad_id;
	private Timestamp fecha_hora;
	private int cantidad;
	private int unidad;
	private double precio;
	private int evaluacion;
	private String descripcion;
	private int estado;

	
	public Espacio_actividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Espacio_actividad(int id, int espacio_id, int tipo_actividad_id, Timestamp fecha_hora, int cantidad, int unidad, double precio, int evaluacion, String descripcion, int estado) {
		super();
		this.id = id;
		this.espacio_id = espacio_id;
		this.tipo_actividad_id = tipo_actividad_id;
		this.fecha_hora = fecha_hora;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.precio = precio;
		this.evaluacion = evaluacion;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Espacio_actividad(int espacio_id, int tipo_actividad_id, Timestamp fecha_hora, int cantidad, int unidad, double precio, int evaluacion, String descripcion, int estado) {
		super();
		this.espacio_id = espacio_id;
		this.tipo_actividad_id = tipo_actividad_id;
		this.fecha_hora = fecha_hora;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.precio = precio;
		this.evaluacion = evaluacion;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getEspacio_id() {
		return espacio_id;
	}

	public void setEspacio_id(int espacio_id) {
		this.espacio_id = espacio_id;
	}
	public int getTipo_actividad_id() {
		return tipo_actividad_id;
	}

	public void setTipo_actividad_id(int tipo_actividad_id) {
		this.tipo_actividad_id = tipo_actividad_id;
	}
	public Timestamp getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Timestamp fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Espacio_actividad [id=" + id + ", espacio_id=" + espacio_id + ", tipo_actividad_id=" + tipo_actividad_id + ", fecha_hora=" + fecha_hora + ", cantidad=" + cantidad + ", unidad=" + unidad + ", precio=" + precio + ", evaluacion=" + evaluacion + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
