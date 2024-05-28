package org.usco.agro.tipo_costo_indirecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_costo_indirectoRepository implements Tipo_costo_indirectoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_costo_indirecto"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.tipo_costo_indirecto";

	String UPDATE_SQL = "UPDATE public.tipo_costo_indirecto"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_costo_indirecto"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_costo_indirecto tipo_costo_indirecto) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_costo_indirecto.getNombre(), tipo_costo_indirecto.getDescripcion(), tipo_costo_indirecto.getEstado() });
	}

	@Override
	public List<Tipo_costo_indirecto> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_costo_indirecto.class));
	}

	@Override
	public int update(int id, Tipo_costo_indirecto tipo_costo_indirecto) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_costo_indirecto.getNombre(), tipo_costo_indirecto.getDescripcion(), tipo_costo_indirecto.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
