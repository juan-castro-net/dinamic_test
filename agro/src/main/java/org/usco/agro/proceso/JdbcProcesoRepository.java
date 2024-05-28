package org.usco.agro.proceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProcesoRepository implements ProcesoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.proceso"
		+ "(tipo_produccion_id, nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, tipo_produccion_id, nombre, descripcion, estado"
		+ " FROM public.proceso";

	String UPDATE_SQL = "UPDATE public.proceso"
		+ " SET tipo_produccion_id=?, nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.proceso"
		+ " WHERE id=?";


	@Override
	public int create(Proceso proceso) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { proceso.getTipo_produccion_id(), proceso.getNombre(), proceso.getDescripcion(), proceso.getEstado() });
	}

	@Override
	public List<Proceso> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Proceso.class));
	}

	@Override
	public int update(int id, Proceso proceso) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { proceso.getTipo_produccion_id(), proceso.getNombre(), proceso.getDescripcion(), proceso.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
