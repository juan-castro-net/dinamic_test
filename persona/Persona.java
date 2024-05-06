package org.usco.test.persona;

import java.sql.Timestamp;
import java.sql.Date;
/**
 * Clase que representa a una persona, con todos sus datos personales y de identificación.
 * Incluye información como nombre, apellido, tipo y número de identificación, género, entre otros.
 */


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

    /**
     * Constructor por defecto.
     */
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
    /**
     * Constructor completo de la clase Persona.
     *
     * @param id Identificador único de la persona.
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param tipo_identificacion Tipo de identificación de la persona (código numérico).
     * @param num_identificacion Número de identificación de la persona.
     * @param genero Género de la persona (true para masculino, false para femenino).
     * @param fecha_nacimiento Fecha de nacimiento de la persona.
     * @param email Correo electrónico de la persona.
     * @param direccion Dirección residencial de la persona.
     * @param celular Número de celular de la persona.
     * @param estado Estado actual de la persona en el sistema (activo/inactivo).
     */
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

	
	
	
    /**
     * Constructor con parámetros para una nueva persona sin ID.
     *
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param tipo_identificacion Tipo de identificación de la persona.
     * @param num_identificacion Número de identificación de la persona.
     * @param genero Género de la persona.
     * @param fecha_nacimiento Fecha de nacimiento de la persona.
     * @param email Correo electrónico de la persona.
     * @param direccion Dirección de la persona.
     * @param celular Número de celular de la persona.
     * @param estado Estado de la persona en el sistema.
     */
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

	
    /**
     * Obtiene el identificador único de la persona.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la persona.
     * @param id el nuevo identificador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre el nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * @return apellido.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     * @param apellido el nuevo apellido de la persona.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el tipo de identificación de la persona.
     * @return tipo_identificacion.
     */
    public int getTipo_identificacion() {
        return tipo_identificacion;
    }

    /**
     * Establece el tipo de identificación de la persona.
     * @param tipo_identificacion el nuevo tipo de identificación.
     */
    public void setTipo_identificacion(int tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    /**
     * Obtiene el número de identificación de la persona.
     * @return num_identificacion.
     */
    public String getNum_identificacion() {
        return num_identificacion;
    }

    /**
     * Establece el número de identificación de la persona.
     * @param num_identificacion el nuevo número de identificación.
     */
    public void setNum_identificacion(String num_identificacion) {
        this.num_identificacion = num_identificacion;
    }

    /**
     * Obtiene el género de la persona.
     * @return genero.
     */
    public boolean getGenero() {
        return genero;
    }

    /**
     * Establece el género de la persona.
     * @param genero el género de la persona, true para masculino, false para femenino.
     */
    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * @return fecha_nacimiento.
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * @param fecha_nacimiento la nueva fecha de nacimiento.
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico de la persona.
     * @param email el nuevo correo electrónico.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la dirección de la persona.
     * @return direccion.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la persona.
     * @param direccion la nueva dirección.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de celular de la persona.
     * @return celular.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular de la persona.
     * @param celular el nuevo número de celular.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtiene el estado actual de la persona en el sistema, siendo 1 para activo y 0 para inactivo.
     * @return estado.
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la persona en el sistema.
     * @param estado el nuevo estado, 1 para activo y 0 para inactivo.
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Devuelve una representación en cadena de la información de la persona.
     * @return Una cadena que representa los datos de la persona.
     */
    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_identificacion=" + tipo_identificacion + ", num_identificacion=" + num_identificacion + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + ", email=" + email + ", direccion=" + direccion + ", celular=" + celular + ", estado=" + estado + "]";
    }
}