package org.usco.agro.tipo_espacio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_espacioRepository implements Tipo_espacioRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_espacio"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.tipo_espacio";

	String UPDATE_SQL = "UPDATE public.tipo_espacio"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_espacio"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_espacio tipo_espacio) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_espacio.getNombre(), tipo_espacio.getDescripcion(), tipo_espacio.getEstado() });
	}

	@Override
	public List<Tipo_espacio> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_espacio.class));
	}

	@Override
	public int update(int id, Tipo_espacio tipo_espacio) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_espacio.getNombre(), tipo_espacio.getDescripcion(), tipo_espacio.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
