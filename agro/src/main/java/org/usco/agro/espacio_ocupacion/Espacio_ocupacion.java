package org.usco.agro.espacio_ocupacion;

import java.sql.Timestamp;
import java.sql.Date;


public class Espacio_ocupacion {
    private int id;
	private int espacio_id;
	private int actividad_ocupacion_id;
	private Date fecha_inicio;
	private Date fecha_fin;
	private int estado;

	
	public Espacio_ocupacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Espacio_ocupacion(int id, int espacio_id, int actividad_ocupacion_id, Date fecha_inicio, Date fecha_fin, int estado) {
		super();
		this.id = id;
		this.espacio_id = espacio_id;
		this.actividad_ocupacion_id = actividad_ocupacion_id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;

	}

	public Espacio_ocupacion(int espacio_id, int actividad_ocupacion_id, Date fecha_inicio, Date fecha_fin, int estado) {
		super();
		this.espacio_id = espacio_id;
		this.actividad_ocupacion_id = actividad_ocupacion_id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
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
	public int getActividad_ocupacion_id() {
		return actividad_ocupacion_id;
	}

	public void setActividad_ocupacion_id(int actividad_ocupacion_id) {
		this.actividad_ocupacion_id = actividad_ocupacion_id;
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
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Espacio_ocupacion [id=" + id + ", espacio_id=" + espacio_id + ", actividad_ocupacion_id=" + actividad_ocupacion_id + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", estado=" + estado + "]";
	}
	
}
