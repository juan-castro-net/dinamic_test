package org.usco.agro.actividad_ocupacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcActividad_ocupacionRepository implements Actividad_ocupacionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.actividad_ocupacion"
		+ "(nombre, tipo_actividad_id, evaluacion)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, tipo_actividad_id, evaluacion"
		+ " FROM public.actividad_ocupacion";

	String UPDATE_SQL = "UPDATE public.actividad_ocupacion"
		+ " SET nombre=?, tipo_actividad_id=?, evaluacion=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.actividad_ocupacion"
		+ " WHERE id=?";


	@Override
	public int create(Actividad_ocupacion actividad_ocupacion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { actividad_ocupacion.getNombre(), actividad_ocupacion.getTipo_actividad_id(), actividad_ocupacion.getEvaluacion() });
	}

	@Override
	public List<Actividad_ocupacion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Actividad_ocupacion.class));
	}

	@Override
	public int update(int id, Actividad_ocupacion actividad_ocupacion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { actividad_ocupacion.getNombre(), actividad_ocupacion.getTipo_actividad_id(), actividad_ocupacion.getEvaluacion(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
