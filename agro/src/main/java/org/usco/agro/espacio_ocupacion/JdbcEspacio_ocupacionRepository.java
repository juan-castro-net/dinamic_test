package org.usco.agro.espacio_ocupacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEspacio_ocupacionRepository implements Espacio_ocupacionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.espacio_ocupacion"
		+ "(espacio_id, actividad_ocupacion_id, fecha_inicio, fecha_fin, estado)"
		+ "VALUES (?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, espacio_id, actividad_ocupacion_id, fecha_inicio, fecha_fin, estado"
		+ " FROM public.espacio_ocupacion";

	String UPDATE_SQL = "UPDATE public.espacio_ocupacion"
		+ " SET espacio_id=?, actividad_ocupacion_id=?, fecha_inicio=?, fecha_fin=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.espacio_ocupacion"
		+ " WHERE id=?";


	@Override
	public int create(Espacio_ocupacion espacio_ocupacion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { espacio_ocupacion.getEspacio_id(), espacio_ocupacion.getActividad_ocupacion_id(), espacio_ocupacion.getFecha_inicio(), espacio_ocupacion.getFecha_fin(), espacio_ocupacion.getEstado() });
	}

	@Override
	public List<Espacio_ocupacion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Espacio_ocupacion.class));
	}

	@Override
	public int update(int id, Espacio_ocupacion espacio_ocupacion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { espacio_ocupacion.getEspacio_id(), espacio_ocupacion.getActividad_ocupacion_id(), espacio_ocupacion.getFecha_inicio(), espacio_ocupacion.getFecha_fin(), espacio_ocupacion.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
