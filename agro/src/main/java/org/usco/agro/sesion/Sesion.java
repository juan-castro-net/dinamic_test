package org.usco.agro.sesion;

import java.sql.Timestamp;
import java.sql.Date;


public class Sesion {
    private int id;
	private int usuario_id;
	private Timestamp fecha_hora_start;
	private Timestamp fecha_hora_end;
	private String direccion_ip;

	
	public Sesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sesion(int id, int usuario_id, Timestamp fecha_hora_start, Timestamp fecha_hora_end, String direccion_ip) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.fecha_hora_start = fecha_hora_start;
		this.fecha_hora_end = fecha_hora_end;
		this.direccion_ip = direccion_ip;

	}

	public Sesion(int usuario_id, Timestamp fecha_hora_start, Timestamp fecha_hora_end, String direccion_ip) {
		super();
		this.usuario_id = usuario_id;
		this.fecha_hora_start = fecha_hora_start;
		this.fecha_hora_end = fecha_hora_end;
		this.direccion_ip = direccion_ip;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public Timestamp getFecha_hora_start() {
		return fecha_hora_start;
	}

	public void setFecha_hora_start(Timestamp fecha_hora_start) {
		this.fecha_hora_start = fecha_hora_start;
	}
	public Timestamp getFecha_hora_end() {
		return fecha_hora_end;
	}

	public void setFecha_hora_end(Timestamp fecha_hora_end) {
		this.fecha_hora_end = fecha_hora_end;
	}
	public String getDireccion_ip() {
		return direccion_ip;
	}

	public void setDireccion_ip(String direccion_ip) {
		this.direccion_ip = direccion_ip;
	}

    
	@Override
	public String toString() {
		return "Sesion [id=" + id + ", usuario_id=" + usuario_id + ", fecha_hora_start=" + fecha_hora_start + ", fecha_hora_end=" + fecha_hora_end + ", direccion_ip=" + direccion_ip + "]";
	}
	
}
