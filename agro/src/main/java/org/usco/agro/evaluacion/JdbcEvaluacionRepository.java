package org.usco.agro.evaluacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEvaluacionRepository implements EvaluacionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.evaluacion"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.evaluacion";

	String UPDATE_SQL = "UPDATE public.evaluacion"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.evaluacion"
		+ " WHERE id=?";


	@Override
	public int create(Evaluacion evaluacion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { evaluacion.getNombre(), evaluacion.getDescripcion(), evaluacion.getEstado() });
	}

	@Override
	public List<Evaluacion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Evaluacion.class));
	}

	@Override
	public int update(int id, Evaluacion evaluacion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { evaluacion.getNombre(), evaluacion.getDescripcion(), evaluacion.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
