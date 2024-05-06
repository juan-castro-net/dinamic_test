package org.usco.test.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEstadoRepository implements EstadoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.estado"
		+ "(nombre, descripcion)"
		+ "VALUES (?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion"
		+ " FROM public.estado";

	String UPDATE_SQL = "UPDATE public.estado"
		+ " SET nombre=?, descripcion=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.estado"
		+ " WHERE id=?";


	@Override
	public int create(Estado estado) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { estado.getNombre(), estado.getDescripcion() });
	}

	@Override
	public List<Estado> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Estado.class));
	}

	@Override
	public int update(int id, Estado estado) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { estado.getNombre(), estado.getDescripcion(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
