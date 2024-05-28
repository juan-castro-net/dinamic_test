package org.usco.agro.actividad_programacion;

import java.sql.Timestamp;
import java.sql.Date;


public class Actividad_programacion {
    private int id;
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private int tipo_produccion_proceso_id;
	private String descripcion;
	private int estado;

	
	public Actividad_programacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actividad_programacion(int id, String nombre, Date fecha_inicio, Date fecha_fin, int tipo_produccion_proceso_id, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.tipo_produccion_proceso_id = tipo_produccion_proceso_id;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Actividad_programacion(String nombre, Date fecha_inicio, Date fecha_fin, int tipo_produccion_proceso_id, String descripcion, int estado) {
		super();
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.tipo_produccion_proceso_id = tipo_produccion_proceso_id;
		this.descripcion = descripcion;
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
	public int getTipo_produccion_proceso_id() {
		return tipo_produccion_proceso_id;
	}

	public void setTipo_produccion_proceso_id(int tipo_produccion_proceso_id) {
		this.tipo_produccion_proceso_id = tipo_produccion_proceso_id;
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
		return "Actividad_programacion [id=" + id + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", tipo_produccion_proceso_id=" + tipo_produccion_proceso_id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
