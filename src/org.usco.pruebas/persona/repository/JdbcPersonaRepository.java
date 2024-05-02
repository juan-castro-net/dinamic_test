package org.usco.pruebas.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPersonaRepository implements PersonaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

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


	@Override
	public int create(Persona persona) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { persona.getId(), persona.getNombre(), persona.getApellido(), persona.getTipo_identificacion(), persona.getNum_identificacion(), persona.getGenero(), persona.getFecha_nacimiento(), persona.getEmail(), persona.getDireccion(), persona.getCelular(), persona.getEstado() });
	}

	@Override
	public List<Persona> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Persona.class));
	}

	@Override
	public int update(int id, Persona persona) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { persona.getId(), persona.getNombre(), persona.getApellido(), persona.getTipo_identificacion(), persona.getNum_identificacion(), persona.getGenero(), persona.getFecha_nacimiento(), persona.getEmail(), persona.getDireccion(), persona.getCelular(), persona.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
