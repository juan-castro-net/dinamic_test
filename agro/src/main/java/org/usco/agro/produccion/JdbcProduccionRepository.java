package org.usco.agro.produccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProduccionRepository implements ProduccionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.produccion"
		+ "(nombre, tipo_produccion_id, descripcion, fecha_inicio, fecha_final, espacio_id, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, tipo_produccion_id, descripcion, fecha_inicio, fecha_final, espacio_id, estado"
		+ " FROM public.produccion";

	String UPDATE_SQL = "UPDATE public.produccion"
		+ " SET nombre=?, tipo_produccion_id=?, descripcion=?, fecha_inicio=?, fecha_final=?, espacio_id=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.produccion"
		+ " WHERE id=?";


	@Override
	public int create(Produccion produccion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { produccion.getNombre(), produccion.getTipo_produccion_id(), produccion.getDescripcion(), produccion.getFecha_inicio(), produccion.getFecha_final(), produccion.getEspacio_id(), produccion.getEstado() });
	}

	@Override
	public List<Produccion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Produccion.class));
	}

	@Override
	public int update(int id, Produccion produccion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { produccion.getNombre(), produccion.getTipo_produccion_id(), produccion.getDescripcion(), produccion.getFecha_inicio(), produccion.getFecha_final(), produccion.getEspacio_id(), produccion.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
