package org.usco.pruebas.sesion;

import java.sql.Timestamp;
import java.sql.Date;


public class Sesion {
    private int id;
	private int usuario;
	private Timestamp fecha_hora_start;
	private Timestamp fecha_hora_end;
	private String ip;

	
	public Sesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sesion(int id, int usuario, Timestamp fecha_hora_start, Timestamp fecha_hora_end, String ip) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha_hora_start = fecha_hora_start;
		this.fecha_hora_end = fecha_hora_end;
		this.ip = ip;

	}

	public Sesion(int usuario, Timestamp fecha_hora_start, Timestamp fecha_hora_end, String ip) {
		super();
		this.usuario = usuario;
		this.fecha_hora_start = fecha_hora_start;
		this.fecha_hora_end = fecha_hora_end;
		this.ip = ip;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
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
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

    
	@Override
	public String toString() {
		return "Sesion [id=" + id + ", usuario=" + usuario + ", fecha_hora_start=" + fecha_hora_start + ", fecha_hora_end=" + fecha_hora_end + ", ip=" + ip + "]";
	}
	
}
