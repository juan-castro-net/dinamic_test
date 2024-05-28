package org.usco.agro.metodo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcMetodoRepository implements MetodoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.metodo"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.metodo";

	String UPDATE_SQL = "UPDATE public.metodo"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.metodo"
		+ " WHERE id=?";


	@Override
	public int create(Metodo metodo) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { metodo.getNombre(), metodo.getDescripcion(), metodo.getEstado() });
	}

	@Override
	public List<Metodo> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Metodo.class));
	}

	@Override
	public int update(int id, Metodo metodo) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { metodo.getNombre(), metodo.getDescripcion(), metodo.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
