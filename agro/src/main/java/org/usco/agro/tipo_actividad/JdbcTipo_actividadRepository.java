package org.usco.agro.tipo_actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_actividadRepository implements Tipo_actividadRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_actividad"
		+ "(categoria_actividad_id, proceso_id, nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, categoria_actividad_id, proceso_id, nombre, descripcion, estado"
		+ " FROM public.tipo_actividad";

	String UPDATE_SQL = "UPDATE public.tipo_actividad"
		+ " SET categoria_actividad_id=?, proceso_id=?, nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_actividad"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_actividad tipo_actividad) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_actividad.getCategoria_actividad_id(), tipo_actividad.getProceso_id(), tipo_actividad.getNombre(), tipo_actividad.getDescripcion(), tipo_actividad.getEstado() });
	}

	@Override
	public List<Tipo_actividad> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_actividad.class));
	}

	@Override
	public int update(int id, Tipo_actividad tipo_actividad) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_actividad.getCategoria_actividad_id(), tipo_actividad.getProceso_id(), tipo_actividad.getNombre(), tipo_actividad.getDescripcion(), tipo_actividad.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
