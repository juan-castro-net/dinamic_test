package org.usco.agro.modulo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcModuloRepository implements ModuloRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.modulo"
		+ "(nombre, url, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, url, descripcion, estado"
		+ " FROM public.modulo";

	String UPDATE_SQL = "UPDATE public.modulo"
		+ " SET nombre=?, url=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.modulo"
		+ " WHERE id=?";


	@Override
	public int create(Modulo modulo) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { modulo.getNombre(), modulo.getUrl(), modulo.getDescripcion(), modulo.getEstado() });
	}

	@Override
	public List<Modulo> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Modulo.class));
	}

	@Override
	public int update(int id, Modulo modulo) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { modulo.getNombre(), modulo.getUrl(), modulo.getDescripcion(), modulo.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
