package org.usco.agro.tipo_produccion_proceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_produccion_procesoRepository implements Tipo_produccion_procesoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_produccion_proceso"
		+ "(tipo_produccion_id, proceso_id, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, tipo_produccion_id, proceso_id, descripcion, estado"
		+ " FROM public.tipo_produccion_proceso";

	String UPDATE_SQL = "UPDATE public.tipo_produccion_proceso"
		+ " SET tipo_produccion_id=?, proceso_id=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_produccion_proceso"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_produccion_proceso tipo_produccion_proceso) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_produccion_proceso.getTipo_produccion_id(), tipo_produccion_proceso.getProceso_id(), tipo_produccion_proceso.getDescripcion(), tipo_produccion_proceso.getEstado() });
	}

	@Override
	public List<Tipo_produccion_proceso> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_produccion_proceso.class));
	}

	@Override
	public int update(int id, Tipo_produccion_proceso tipo_produccion_proceso) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_produccion_proceso.getTipo_produccion_id(), tipo_produccion_proceso.getProceso_id(), tipo_produccion_proceso.getDescripcion(), tipo_produccion_proceso.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
