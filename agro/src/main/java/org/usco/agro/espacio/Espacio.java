package org.usco.agro.espacio;

import java.sql.Timestamp;
import java.sql.Date;


public class Espacio {
    private int id;
	private int bloque_id;
	private int tipo_espacio_id;
	private String nombre;
	private String geolocalizacion;
	private String coordenadas;
	private String descripcion;
	private int estado;

	
	public Espacio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Espacio(int id, int bloque_id, int tipo_espacio_id, String nombre, String geolocalizacion, String coordenadas, String descripcion, int estado) {
		super();
		this.id = id;
		this.bloque_id = bloque_id;
		this.tipo_espacio_id = tipo_espacio_id;
		this.nombre = nombre;
		this.geolocalizacion = geolocalizacion;
		this.coordenadas = coordenadas;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Espacio(int bloque_id, int tipo_espacio_id, String nombre, String geolocalizacion, String coordenadas, String descripcion, int estado) {
		super();
		this.bloque_id = bloque_id;
		this.tipo_espacio_id = tipo_espacio_id;
		this.nombre = nombre;
		this.geolocalizacion = geolocalizacion;
		this.coordenadas = coordenadas;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getBloque_id() {
		return bloque_id;
	}

	public void setBloque_id(int bloque_id) {
		this.bloque_id = bloque_id;
	}
	public int getTipo_espacio_id() {
		return tipo_espacio_id;
	}

	public void setTipo_espacio_id(int tipo_espacio_id) {
		this.tipo_espacio_id = tipo_espacio_id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}

	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
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
		return "Espacio [id=" + id + ", bloque_id=" + bloque_id + ", tipo_espacio_id=" + tipo_espacio_id + ", nombre=" + nombre + ", geolocalizacion=" + geolocalizacion + ", coordenadas=" + coordenadas + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
