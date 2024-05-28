package org.usco.agro.usuario_perfil;

import java.sql.Timestamp;
import java.sql.Date;


public class Usuario_perfil {
    private int id;
	private int usuario_id;
	private int perfil_id;
	private int estado;

	
	public Usuario_perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario_perfil(int id, int usuario_id, int perfil_id, int estado) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.perfil_id = perfil_id;
		this.estado = estado;

	}

	public Usuario_perfil(int usuario_id, int perfil_id, int estado) {
		super();
		this.usuario_id = usuario_id;
		this.perfil_id = perfil_id;
		this.estado = estado;

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
	public int getPerfil_id() {
		return perfil_id;
	}

	public void setPerfil_id(int perfil_id) {
		this.perfil_id = perfil_id;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Usuario_perfil [id=" + id + ", usuario_id=" + usuario_id + ", perfil_id=" + perfil_id + ", estado=" + estado + "]";
	}
	
}
