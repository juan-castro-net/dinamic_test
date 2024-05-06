package org.usco.test.permisos;

import java.sql.Timestamp;
import java.sql.Date;


public class Permisos {
    private int id;
	private int perfil;
	private int modulo;
	private int tipo_permiso;

	
	public Permisos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permisos(int id, int perfil, int modulo, int tipo_permiso) {
		super();
		this.id = id;
		this.perfil = perfil;
		this.modulo = modulo;
		this.tipo_permiso = tipo_permiso;

	}

	public Permisos(int perfil, int modulo, int tipo_permiso) {
		super();
		this.perfil = perfil;
		this.modulo = modulo;
		this.tipo_permiso = tipo_permiso;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}
	public int getTipo_permiso() {
		return tipo_permiso;
	}

	public void setTipo_permiso(int tipo_permiso) {
		this.tipo_permiso = tipo_permiso;
	}

    
	@Override
	public String toString() {
		return "Permisos [id=" + id + ", perfil=" + perfil + ", modulo=" + modulo + ", tipo_permiso=" + tipo_permiso + "]";
	}
	
}
