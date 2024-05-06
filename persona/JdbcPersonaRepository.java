package org.usco.test.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * Implementación de {@link PersonaRepository} utilizando JdbcTemplate para interactuar con una base de datos SQL.
 * Proporciona funcionalidades para crear, leer, actualizar y eliminar registros de personas.
 */
@Repository
public class JdbcPersonaRepository implements PersonaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
    // SQL queries
	String CREATE_SQL = "INSERT INTO public.persona"
		+ "(nombre, apellido, tipo_identificacion, num_identificacion, genero, fecha_nacimiento, email, direccion, celular, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, apellido, tipo_identificacion, num_identificacion, genero, fecha_nacimiento, email, direccion, celular, estado"
		+ " FROM public.persona";

	String UPDATE_SQL = "UPDATE public.persona"
		+ " SET nombre=?, apellido=?, tipo_identificacion=?, num_identificacion=?, genero=?, fecha_nacimiento=?, email=?, direccion=?, celular=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.persona"
		+ " WHERE id=?";


    /**
     * Crea una nueva persona en la base de datos.
     * 
     * @param persona Objeto Persona conteniendo los datos a ser insertados.
     * @return El número de filas afectadas.
     */
	@Override
	public int create(Persona persona) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { persona.getNombre(), persona.getApellido(), persona.getTipo_identificacion(), persona.getNum_identificacion(), persona.getGenero(), persona.getFecha_nacimiento(), persona.getEmail(), persona.getDireccion(), persona.getCelular(), persona.getEstado() });
	}

	
    /**
     * Lee todas las personas almacenadas en la base de datos.
     * 
     * @return Una lista de objetos Persona.
     */
	@Override
	public List<Persona> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Persona.class));
	}

	
    /**
     * Actualiza los datos de una persona existente en la base de datos basado en su ID.
     * 
     * @param id El ID de la persona a actualizar.
     * @param persona Objeto Persona con los datos actualizados.
     * @return El número de filas afectadas.
     */
	@Override
	public int update(int id, Persona persona) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { persona.getNombre(), persona.getApellido(), persona.getTipo_identificacion(), persona.getNum_identificacion(), persona.getGenero(), persona.getFecha_nacimiento(), persona.getEmail(), persona.getDireccion(), persona.getCelular(), persona.getEstado(), id });
	}

	
    /**
     * Elimina una persona de la base de datos basado en su ID.
     * 
     * @param id El ID de la persona a eliminar.
     * @return El número de filas afectadas.
     */
	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}