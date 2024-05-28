package org.usco.agro.actividad_produccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcActividad_produccionRepository implements Actividad_produccionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.actividad_produccion"
		+ "(nombre, actividad_programacion_id, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, actividad_programacion_id, descripcion, estado"
		+ " FROM public.actividad_produccion";

	String UPDATE_SQL = "UPDATE public.actividad_produccion"
		+ " SET nombre=?, actividad_programacion_id=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.actividad_produccion"
		+ " WHERE id=?";


	@Override
	public int create(Actividad_produccion actividad_produccion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { actividad_produccion.getNombre(), actividad_produccion.getActividad_programacion_id(), actividad_produccion.getDescripcion(), actividad_produccion.getEstado() });
	}

	@Override
	public List<Actividad_produccion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Actividad_produccion.class));
	}

	@Override
	public int update(int id, Actividad_produccion actividad_produccion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { actividad_produccion.getNombre(), actividad_produccion.getActividad_programacion_id(), actividad_produccion.getDescripcion(), actividad_produccion.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
