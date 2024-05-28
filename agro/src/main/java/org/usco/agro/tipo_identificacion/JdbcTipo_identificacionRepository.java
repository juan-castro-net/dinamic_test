package org.usco.agro.tipo_identificacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_identificacionRepository implements Tipo_identificacionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_identificacion"
		+ "(nombre, descripcion, estado_id)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado_id"
		+ " FROM public.tipo_identificacion";

	String UPDATE_SQL = "UPDATE public.tipo_identificacion"
		+ " SET nombre=?, descripcion=?, estado_id=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_identificacion"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_identificacion tipo_identificacion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_identificacion.getNombre(), tipo_identificacion.getDescripcion(), tipo_identificacion.getEstado_id() });
	}

	@Override
	public List<Tipo_identificacion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_identificacion.class));
	}

	@Override
	public int update(int id, Tipo_identificacion tipo_identificacion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_identificacion.getNombre(), tipo_identificacion.getDescripcion(), tipo_identificacion.getEstado_id(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
