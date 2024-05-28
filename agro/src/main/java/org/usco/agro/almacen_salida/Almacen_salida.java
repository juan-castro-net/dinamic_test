package org.usco.agro.almacen_salida;

import java.sql.Timestamp;
import java.sql.Date;


public class Almacen_salida {
    private int id;
	private Date fecha;
	private int empresa_id;
	private int almacen_id;
	private int espacio_id;
	private String descripcion;
	private int estado;

	
	public Almacen_salida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacen_salida(int id, Date fecha, int empresa_id, int almacen_id, int espacio_id, String descripcion, int estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.empresa_id = empresa_id;
		this.almacen_id = almacen_id;
		this.espacio_id = espacio_id;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Almacen_salida(Date fecha, int empresa_id, int almacen_id, int espacio_id, String descripcion, int estado) {
		super();
		this.fecha = fecha;
		this.empresa_id = empresa_id;
		this.almacen_id = almacen_id;
		this.espacio_id = espacio_id;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}
	public int getAlmacen_id() {
		return almacen_id;
	}

	public void setAlmacen_id(int almacen_id) {
		this.almacen_id = almacen_id;
	}
	public int getEspacio_id() {
		return espacio_id;
	}

	public void setEspacio_id(int espacio_id) {
		this.espacio_id = espacio_id;
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
		return "Almacen_salida [id=" + id + ", fecha=" + fecha + ", empresa_id=" + empresa_id + ", almacen_id=" + almacen_id + ", espacio_id=" + espacio_id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
