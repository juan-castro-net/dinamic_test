package org.usco.agro.sede;

import java.sql.Timestamp;
import java.sql.Date;


public class Sede {
    private int id;
	private int grupo_id;
	private int tipo_sede_id;
	private String nombre;
	private int municipio_id;
	private String geolocalizacion;
	private String coordenadas;
	private double area;
	private String comuna;
	private String descripcion;
	private int estado;

	
	public Sede() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sede(int id, int grupo_id, int tipo_sede_id, String nombre, int municipio_id, String geolocalizacion, String coordenadas, double area, String comuna, String descripcion, int estado) {
		super();
		this.id = id;
		this.grupo_id = grupo_id;
		this.tipo_sede_id = tipo_sede_id;
		this.nombre = nombre;
		this.municipio_id = municipio_id;
		this.geolocalizacion = geolocalizacion;
		this.coordenadas = coordenadas;
		this.area = area;
		this.comuna = comuna;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Sede(int grupo_id, int tipo_sede_id, String nombre, int municipio_id, String geolocalizacion, String coordenadas, double area, String comuna, String descripcion, int estado) {
		super();
		this.grupo_id = grupo_id;
		this.tipo_sede_id = tipo_sede_id;
		this.nombre = nombre;
		this.municipio_id = municipio_id;
		this.geolocalizacion = geolocalizacion;
		this.coordenadas = coordenadas;
		this.area = area;
		this.comuna = comuna;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getGrupo_id() {
		return grupo_id;
	}

	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}
	public int getTipo_sede_id() {
		return tipo_sede_id;
	}

	public void setTipo_sede_id(int tipo_sede_id) {
		this.tipo_sede_id = tipo_sede_id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMunicipio_id() {
		return municipio_id;
	}

	public void setMunicipio_id(int municipio_id) {
		this.municipio_id = municipio_id;
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
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
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
		return "Sede [id=" + id + ", grupo_id=" + grupo_id + ", tipo_sede_id=" + tipo_sede_id + ", nombre=" + nombre + ", municipio_id=" + municipio_id + ", geolocalizacion=" + geolocalizacion + ", coordenadas=" + coordenadas + ", area=" + area + ", comuna=" + comuna + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
