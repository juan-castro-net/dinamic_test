package org.usco.test.entidad;

import java.sql.Timestamp;
import java.sql.Date;


public class Entidad {
    private int id;
	private String nombre;
	private int municipio;
	private String codigo;
	private int tipoentidad;
	private int estado;
	private String comuna;
	private String geolocalizacion;

	
	public Entidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entidad(int id, String nombre, int municipio, String codigo, int tipoentidad, int estado, String comuna, String geolocalizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
		this.codigo = codigo;
		this.tipoentidad = tipoentidad;
		this.estado = estado;
		this.comuna = comuna;
		this.geolocalizacion = geolocalizacion;

	}

	public Entidad(String nombre, int municipio, String codigo, int tipoentidad, int estado, String comuna, String geolocalizacion) {
		super();
		this.nombre = nombre;
		this.municipio = municipio;
		this.codigo = codigo;
		this.tipoentidad = tipoentidad;
		this.estado = estado;
		this.comuna = comuna;
		this.geolocalizacion = geolocalizacion;

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
	public int getMunicipio() {
		return municipio;
	}

	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getTipoentidad() {
		return tipoentidad;
	}

	public void setTipoentidad(int tipoentidad) {
		this.tipoentidad = tipoentidad;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}

	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

    
	@Override
	public String toString() {
		return "Entidad [id=" + id + ", nombre=" + nombre + ", municipio=" + municipio + ", codigo=" + codigo + ", tipoentidad=" + tipoentidad + ", estado=" + estado + ", comuna=" + comuna + ", geolocalizacion=" + geolocalizacion + "]";
	}
	
}
