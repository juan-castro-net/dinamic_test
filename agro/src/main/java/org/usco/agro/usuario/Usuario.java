package org.usco.agro.usuario;

import java.sql.Timestamp;
import java.sql.Date;


public class Usuario {
    private int id;
	private int persona_id;
	private String email;
	private String password;
	private int estado;

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, int persona_id, String email, String password, int estado) {
		super();
		this.id = id;
		this.persona_id = persona_id;
		this.email = email;
		this.password = password;
		this.estado = estado;

	}

	public Usuario(int persona_id, String email, String password, int estado) {
		super();
		this.persona_id = persona_id;
		this.email = email;
		this.password = password;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(int persona_id) {
		this.persona_id = persona_id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", persona_id=" + persona_id + ", email=" + email + ", password=" + password + ", estado=" + estado + "]";
	}
	
}
