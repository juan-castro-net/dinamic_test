package org.usco.agro.actividad_programacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcActividad_programacionRepository implements Actividad_programacionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.actividad_programacion"
		+ "(nombre, fecha_inicio, fecha_fin, tipo_produccion_proceso_id, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, fecha_inicio, fecha_fin, tipo_produccion_proceso_id, descripcion, estado"
		+ " FROM public.actividad_programacion";

	String UPDATE_SQL = "UPDATE public.actividad_programacion"
		+ " SET nombre=?, fecha_inicio=?, fecha_fin=?, tipo_produccion_proceso_id=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.actividad_programacion"
		+ " WHERE id=?";


	@Override
	public int create(Actividad_programacion actividad_programacion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { actividad_programacion.getNombre(), actividad_programacion.getFecha_inicio(), actividad_programacion.getFecha_fin(), actividad_programacion.getTipo_produccion_proceso_id(), actividad_programacion.getDescripcion(), actividad_programacion.getEstado() });
	}

	@Override
	public List<Actividad_programacion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Actividad_programacion.class));
	}

	@Override
	public int update(int id, Actividad_programacion actividad_programacion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { actividad_programacion.getNombre(), actividad_programacion.getFecha_inicio(), actividad_programacion.getFecha_fin(), actividad_programacion.getTipo_produccion_proceso_id(), actividad_programacion.getDescripcion(), actividad_programacion.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
