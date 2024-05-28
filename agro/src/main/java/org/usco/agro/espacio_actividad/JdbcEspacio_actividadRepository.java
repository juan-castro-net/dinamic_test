package org.usco.agro.espacio_actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEspacio_actividadRepository implements Espacio_actividadRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.espacio_actividad"
		+ "(espacio_id, tipo_actividad_id, fecha_hora, cantidad, unidad, precio, evaluacion, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, espacio_id, tipo_actividad_id, fecha_hora, cantidad, unidad, precio, evaluacion, descripcion, estado"
		+ " FROM public.espacio_actividad";

	String UPDATE_SQL = "UPDATE public.espacio_actividad"
		+ " SET espacio_id=?, tipo_actividad_id=?, fecha_hora=?, cantidad=?, unidad=?, precio=?, evaluacion=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.espacio_actividad"
		+ " WHERE id=?";


	@Override
	public int create(Espacio_actividad espacio_actividad) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { espacio_actividad.getEspacio_id(), espacio_actividad.getTipo_actividad_id(), espacio_actividad.getFecha_hora(), espacio_actividad.getCantidad(), espacio_actividad.getUnidad(), espacio_actividad.getPrecio(), espacio_actividad.getEvaluacion(), espacio_actividad.getDescripcion(), espacio_actividad.getEstado() });
	}

	@Override
	public List<Espacio_actividad> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Espacio_actividad.class));
	}

	@Override
	public int update(int id, Espacio_actividad espacio_actividad) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { espacio_actividad.getEspacio_id(), espacio_actividad.getTipo_actividad_id(), espacio_actividad.getFecha_hora(), espacio_actividad.getCantidad(), espacio_actividad.getUnidad(), espacio_actividad.getPrecio(), espacio_actividad.getEvaluacion(), espacio_actividad.getDescripcion(), espacio_actividad.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
