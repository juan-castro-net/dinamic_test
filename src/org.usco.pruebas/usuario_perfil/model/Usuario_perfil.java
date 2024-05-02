package org.usco.pruebas.usuario_perfil;

import java.sql.Timestamp;
import java.sql.Date;


public class Usuario_perfil {
    private int id;
	private int usuario;
	private int perfil;
	private int estado;

	
	public Usuario_perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario_perfil(int id, int usuario, int perfil, int estado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.perfil = perfil;
		this.estado = estado;

	}

	public Usuario_perfil(int usuario, int perfil, int estado) {
		super();
		this.usuario = usuario;
		this.perfil = perfil;
		this.estado = estado;

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
	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Usuario_perfil [id=" + id + ", usuario=" + usuario + ", perfil=" + perfil + ", estado=" + estado + "]";
	}
	
}
