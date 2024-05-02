package org.usco.pruebas.tipo_permiso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipo_permisoRepository implements Tipo_permisoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipo_permiso"
		+ "(nombre)"
		+ "VALUES (?)";

	String READ_SQL = "SELECT id, nombre"
		+ " FROM public.tipo_permiso";

	String UPDATE_SQL = "UPDATE public.tipo_permiso"
		+ " SET nombre=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipo_permiso"
		+ " WHERE id=?";


	@Override
	public int create(Tipo_permiso tipo_permiso) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipo_permiso.getId(), tipo_permiso.getNombre() });
	}

	@Override
	public List<Tipo_permiso> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipo_permiso.class));
	}

	@Override
	public int update(int id, Tipo_permiso tipo_permiso) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipo_permiso.getId(), tipo_permiso.getNombre(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
