package org.usco.agro.produccion;

import java.sql.Timestamp;
import java.sql.Date;


public class Produccion {
    private int id;
	private String nombre;
	private int tipo_produccion_id;
	private String descripcion;
	private Date fecha_inicio;
	private Date fecha_final;
	private int espacio_id;
	private int estado;

	
	public Produccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produccion(int id, String nombre, int tipo_produccion_id, String descripcion, Date fecha_inicio, Date fecha_final, int espacio_id, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo_produccion_id = tipo_produccion_id;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.espacio_id = espacio_id;
		this.estado = estado;

	}

	public Produccion(String nombre, int tipo_produccion_id, String descripcion, Date fecha_inicio, Date fecha_final, int espacio_id, int estado) {
		super();
		this.nombre = nombre;
		this.tipo_produccion_id = tipo_produccion_id;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.espacio_id = espacio_id;
		this.estado = estado;

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
	public int getTipo_produccion_id() {
		return tipo_produccion_id;
	}

	public void setTipo_produccion_id(int tipo_produccion_id) {
		this.tipo_produccion_id = tipo_produccion_id;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public int getEspacio_id() {
		return espacio_id;
	}

	public void setEspacio_id(int espacio_id) {
		this.espacio_id = espacio_id;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Produccion [id=" + id + ", nombre=" + nombre + ", tipo_produccion_id=" + tipo_produccion_id + ", descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio + ", fecha_final=" + fecha_final + ", espacio_id=" + espacio_id + ", estado=" + estado + "]";
	}
	
}
