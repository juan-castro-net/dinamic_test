package org.usco.agro.almacen;

import java.sql.Timestamp;
import java.sql.Date;


public class Almacen {
    private int id;
	private String nombre;
	private int sede_id;
	private String geolocalizacion;
	private String coordenadas;
	private String descripcion;
	private int estado;

	
	public Almacen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacen(int id, String nombre, int sede_id, String geolocalizacion, String coordenadas, String descripcion, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sede_id = sede_id;
		this.geolocalizacion = geolocalizacion;
		this.coordenadas = coordenadas;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Almacen(String nombre, int sede_id, String geolocalizacion, String coordenadas, String descripcion, int estado) {
		super();
		this.nombre = nombre;
		this.sede_id = sede_id;
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
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSede_id() {
		return sede_id;
	}

	public void setSede_id(int sede_id) {
		this.sede_id = sede_id;
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
		return "Almacen [id=" + id + ", nombre=" + nombre + ", sede_id=" + sede_id + ", geolocalizacion=" + geolocalizacion + ", coordenadas=" + coordenadas + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
