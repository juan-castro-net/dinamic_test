package org.usco.agro.tipo_bloque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_bloqueRepository implements Tipo_bloqueRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_bloque"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.tipo_bloque";

	String UPDATE_SQL = "UPDATE public.tipo_bloque"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_bloque"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_bloque tipo_bloque) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_bloque.getNombre(), tipo_bloque.getDescripcion(), tipo_bloque.getEstado() });
	}

	@Override
	public List<Tipo_bloque> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_bloque.class));
	}

	@Override
	public int update(int id, Tipo_bloque tipo_bloque) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_bloque.getNombre(), tipo_bloque.getDescripcion(), tipo_bloque.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
