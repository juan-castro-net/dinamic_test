package org.usco.agro.costo_indirecto;

import java.sql.Timestamp;
import java.sql.Date;


public class Costo_indirecto {
    private int id;
	private int espacio_id;
	private int tipo_costo_indirecto_id;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String nombre;
	private double precio;
	private String descripcion;
	private int estado;

	
	public Costo_indirecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Costo_indirecto(int id, int espacio_id, int tipo_costo_indirecto_id, Date fecha_inicio, Date fecha_fin, String nombre, double precio, String descripcion, int estado) {
		super();
		this.id = id;
		this.espacio_id = espacio_id;
		this.tipo_costo_indirecto_id = tipo_costo_indirecto_id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Costo_indirecto(int espacio_id, int tipo_costo_indirecto_id, Date fecha_inicio, Date fecha_fin, String nombre, double precio, String descripcion, int estado) {
		super();
		this.espacio_id = espacio_id;
		this.tipo_costo_indirecto_id = tipo_costo_indirecto_id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.nombre = nombre;
		this.precio = precio;
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
	public int getTipo_costo_indirecto_id() {
		return tipo_costo_indirecto_id;
	}

	public void setTipo_costo_indirecto_id(int tipo_costo_indirecto_id) {
		this.tipo_costo_indirecto_id = tipo_costo_indirecto_id;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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
		return "Costo_indirecto [id=" + id + ", espacio_id=" + espacio_id + ", tipo_costo_indirecto_id=" + tipo_costo_indirecto_id + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
