package org.usco.agro.proveedor;

import java.sql.Timestamp;
import java.sql.Date;


public class Proveedor {
    private int id;
	private int empresa_id;
	private Date fecha_creacion;
	private int estado;

	
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proveedor(int id, int empresa_id, Date fecha_creacion, int estado) {
		super();
		this.id = id;
		this.empresa_id = empresa_id;
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;

	}

	public Proveedor(int empresa_id, Date fecha_creacion, int estado) {
		super();
		this.empresa_id = empresa_id;
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", empresa_id=" + empresa_id + ", fecha_creacion=" + fecha_creacion + ", estado=" + estado + "]";
	}
	
}
