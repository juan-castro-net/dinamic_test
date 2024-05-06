package org.usco.test.usuario;

import java.sql.Timestamp;
import java.sql.Date;


public class Usuario {
    private int id;
	private String login_username;
	private int persona;
	private int estado;

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String login_username, int persona, int estado) {
		super();
		this.id = id;
		this.login_username = login_username;
		this.persona = persona;
		this.estado = estado;

	}

	public Usuario(String login_username, int persona, int estado) {
		super();
		this.login_username = login_username;
		this.persona = persona;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_username() {
		return login_username;
	}

	public void setLogin_username(String login_username) {
		this.login_username = login_username;
	}
	public int getPersona() {
		return persona;
	}

	public void setPersona(int persona) {
		this.persona = persona;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login_username=" + login_username + ", persona=" + persona + ", estado=" + estado + "]";
	}
	
}
