package org.usco.agro.tipo_produccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_produccionRepository implements Tipo_produccionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_produccion"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.tipo_produccion";

	String UPDATE_SQL = "UPDATE public.tipo_produccion"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_produccion"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_produccion tipo_produccion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_produccion.getNombre(), tipo_produccion.getDescripcion(), tipo_produccion.getEstado() });
	}

	@Override
	public List<Tipo_produccion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_produccion.class));
	}

	@Override
	public int update(int id, Tipo_produccion tipo_produccion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_produccion.getNombre(), tipo_produccion.getDescripcion(), tipo_produccion.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
