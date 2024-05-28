package org.usco.agro.persona;

import java.sql.Timestamp;
import java.sql.Date;


public class Persona {
    private int id;
	private int tipo_identificacion;
	private String identificacion;
	private String nombre;
	private String apellido;
	private boolean genero;
	private Date fecha_nacimiento;
	private int estrato;
	private String direccion;
	private String email_personal;
	private Long celular;
	private int estado;

	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int id, int tipo_identificacion, String identificacion, String nombre, String apellido, boolean genero, Date fecha_nacimiento, int estrato, String direccion, String email_personal, Long celular, int estado) {
		super();
		this.id = id;
		this.tipo_identificacion = tipo_identificacion;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fecha_nacimiento = fecha_nacimiento;
		this.estrato = estrato;
		this.direccion = direccion;
		this.email_personal = email_personal;
		this.celular = celular;
		this.estado = estado;

	}

	public Persona(int tipo_identificacion, String identificacion, String nombre, String apellido, boolean genero, Date fecha_nacimiento, int estrato, String direccion, String email_personal, Long celular, int estado) {
		super();
		this.tipo_identificacion = tipo_identificacion;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fecha_nacimiento = fecha_nacimiento;
		this.estrato = estrato;
		this.direccion = direccion;
		this.email_personal = email_personal;
		this.celular = celular;
		this.estado = estado;

	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getTipo_identificacion() {
		return tipo_identificacion;
	}

	public void setTipo_identificacion(int tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}
	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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
	public int getEstrato() {
		return estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail_personal() {
		return email_personal;
	}

	public void setEmail_personal(String email_personal) {
		this.email_personal = email_personal;
	}
	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
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
		return "Persona [id=" + id + ", tipo_identificacion=" + tipo_identificacion + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + ", estrato=" + estrato + ", direccion=" + direccion + ", email_personal=" + email_personal + ", celular=" + celular + ", estado=" + estado + "]";
	}
	
}
