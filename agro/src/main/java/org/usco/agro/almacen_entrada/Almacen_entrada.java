package org.usco.agro.almacen_entrada;

import java.sql.Timestamp;
import java.sql.Date;


public class Almacen_entrada {
    private int id;
	private int proveedor_id;
	private int almacen_id;
	private int espacio_id;
	private Date fecha;
	private String descripcion;
	private int estado;

	
	public Almacen_entrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacen_entrada(int id, int proveedor_id, int almacen_id, int espacio_id, Date fecha, String descripcion, int estado) {
		super();
		this.id = id;
		this.proveedor_id = proveedor_id;
		this.almacen_id = almacen_id;
		this.espacio_id = espacio_id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Almacen_entrada(int proveedor_id, int almacen_id, int espacio_id, Date fecha, String descripcion, int estado) {
		super();
		this.proveedor_id = proveedor_id;
		this.almacen_id = almacen_id;
		this.espacio_id = espacio_id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getProveedor_id() {
		return proveedor_id;
	}

	public void setProveedor_id(int proveedor_id) {
		this.proveedor_id = proveedor_id;
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
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
		return "Almacen_entrada [id=" + id + ", proveedor_id=" + proveedor_id + ", almacen_id=" + almacen_id + ", espacio_id=" + espacio_id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
