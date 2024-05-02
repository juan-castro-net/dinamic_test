package org.usco.pruebas.persona;

import java.sql.Timestamp;
import java.sql.Date;


public class Persona {
    private int id;
	private String nombre;
	private String apellido;
	private int tipo_identificacion;
	private String num_identificacion;
	private boolean genero;
	private Date fecha_nacimiento;
	private String email;
	private String direccion;
	private String celular;
	private int estado;

	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int id, String nombre, String apellido, int tipo_identificacion, String num_identificacion, boolean genero, Date fecha_nacimiento, String email, String direccion, String celular, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_identificacion = tipo_identificacion;
		this.num_identificacion = num_identificacion;
		this.genero = genero;
		this.fecha_nacimiento = fecha_nacimiento;
		this.email = email;
		this.direccion = direccion;
		this.celular = celular;
		this.estado = estado;

	}

	public Persona(String nombre, String apellido, int tipo_identificacion, String num_identificacion, boolean genero, Date fecha_nacimiento, String email, String direccion, String celular, int estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_identificacion = tipo_identificacion;
		this.num_identificacion = num_identificacion;
		this.genero = genero;
		this.fecha_nacimiento = fecha_nacimiento;
		this.email = email;
		this.direccion = direccion;
		this.celular = celular;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getTipo_identificacion() {
		return tipo_identificacion;
	}

	public void setTipo_identificacion(int tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}
	public String getNum_identificacion() {
		return num_identificacion;
	}

	public void setNum_identificacion(String num_identificacion) {
		this.num_identificacion = num_identificacion;
	}
	public boolean getGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

    
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_identificacion=" + tipo_identificacion + ", num_identificacion=" + num_identificacion + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + ", email=" + email + ", direccion=" + direccion + ", celular=" + celular + ", estado=" + estado + "]";
	}
	
}
