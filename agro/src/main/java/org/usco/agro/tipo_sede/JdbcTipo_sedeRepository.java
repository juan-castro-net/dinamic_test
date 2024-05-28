package org.usco.agro.tipo_sede;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_sedeRepository implements Tipo_sedeRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_sede"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.tipo_sede";

	String UPDATE_SQL = "UPDATE public.tipo_sede"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_sede"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_sede tipo_sede) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_sede.getNombre(), tipo_sede.getDescripcion(), tipo_sede.getEstado() });
	}

	@Override
	public List<Tipo_sede> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_sede.class));
	}

	@Override
	public int update(int id, Tipo_sede tipo_sede) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_sede.getNombre(), tipo_sede.getDescripcion(), tipo_sede.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
