package org.usco.agro.permisos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPermisosRepository implements PermisosRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.permisos"
		+ "(modulo_metodo_id, rol, metodo_id)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, modulo_metodo_id, rol, metodo_id"
		+ " FROM public.permisos";

	String UPDATE_SQL = "UPDATE public.permisos"
		+ " SET modulo_metodo_id=?, rol=?, metodo_id=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.permisos"
		+ " WHERE id=?";


	@Override
	public int create(Permisos permisos) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { permisos.getModulo_metodo_id(), permisos.getRol(), permisos.getMetodo_id() });
	}

	@Override
	public List<Permisos> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Permisos.class));
	}

	@Override
	public int update(int id, Permisos permisos) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { permisos.getModulo_metodo_id(), permisos.getRol(), permisos.getMetodo_id(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
