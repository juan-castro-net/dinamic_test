package org.usco.agro.tipo_produccion_proceso;

import java.sql.Timestamp;
import java.sql.Date;


public class Tipo_produccion_proceso {
    private int id;
	private int tipo_produccion_id;
	private int proceso_id;
	private String descripcion;
	private int estado;

	
	public Tipo_produccion_proceso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_produccion_proceso(int id, int tipo_produccion_id, int proceso_id, String descripcion, int estado) {
		super();
		this.id = id;
		this.tipo_produccion_id = tipo_produccion_id;
		this.proceso_id = proceso_id;
		this.descripcion = descripcion;
		this.estado = estado;

	}

	public Tipo_produccion_proceso(int tipo_produccion_id, int proceso_id, String descripcion, int estado) {
		super();
		this.tipo_produccion_id = tipo_produccion_id;
		this.proceso_id = proceso_id;
		this.descripcion = descripcion;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getTipo_produccion_id() {
		return tipo_produccion_id;
	}

	public void setTipo_produccion_id(int tipo_produccion_id) {
		this.tipo_produccion_id = tipo_produccion_id;
	}
	public int getProceso_id() {
		return proceso_id;
	}

	public void setProceso_id(int proceso_id) {
		this.proceso_id = proceso_id;
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
		return "Tipo_produccion_proceso [id=" + id + ", tipo_produccion_id=" + tipo_produccion_id + ", proceso_id=" + proceso_id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
