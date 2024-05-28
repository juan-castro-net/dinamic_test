package org.usco.agro.bloque;

import java.sql.Timestamp;
import java.sql.Date;


public class Bloque {
    private int id;
	private int sede_id;
	private int tipo_bloque_id;
	private String nombre;
	private String geolocalizacion;
	private String coordenadas;
	private int numero_pisos;
	private String descripcion;
	private int estado;

	
	public Bloque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bloque(int id, int sede_id, int tipo_bloque_id, String nombre, String geolocalizacion, String coordenadas, int numero_pisos, String descripcion, int estado) {
		super();
		this.id = id;
		this.sede_id = sede_id;
		this.tipo_bloque_id = tipo_bloque_id;
		this.nombre = nombre;
		this.geolocalizacion = geolocalizacion;
		this.coordenadas = coordenadas;
		this.numero_pisos = numero_pisos;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Bloque(int sede_id, int tipo_bloque_id, String nombre, String geolocalizacion, String coordenadas, int numero_pisos, String descripcion, int estado) {
		super();
		this.sede_id = sede_id;
		this.tipo_bloque_id = tipo_bloque_id;
		this.nombre = nombre;
		this.geolocalizacion = geolocalizacion;
		this.coordenadas = coordenadas;
		this.numero_pisos = numero_pisos;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getSede_id() {
		return sede_id;
	}

	public void setSede_id(int sede_id) {
		this.sede_id = sede_id;
	}
	public int getTipo_bloque_id() {
		return tipo_bloque_id;
	}

	public void setTipo_bloque_id(int tipo_bloque_id) {
		this.tipo_bloque_id = tipo_bloque_id;
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
	public int getNumero_pisos() {
		return numero_pisos;
	}

	public void setNumero_pisos(int numero_pisos) {
		this.numero_pisos = numero_pisos;
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
		return "Bloque [id=" + id + ", sede_id=" + sede_id + ", tipo_bloque_id=" + tipo_bloque_id + ", nombre=" + nombre + ", geolocalizacion=" + geolocalizacion + ", coordenadas=" + coordenadas + ", numero_pisos=" + numero_pisos + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
