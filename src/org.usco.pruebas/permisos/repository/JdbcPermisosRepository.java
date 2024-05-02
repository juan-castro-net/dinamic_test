package org.usco.pruebas.permisos;

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
		+ "(perfil, modulo, tipo_permiso)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, perfil, modulo, tipo_permiso"
		+ " FROM public.permisos";

	String UPDATE_SQL = "UPDATE public.permisos"
		+ " SET perfil=?, modulo=?, tipo_permiso=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.permisos"
		+ " WHERE id=?";


	@Override
	public int create(Permisos permisos) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { permisos.getId(), permisos.getPerfil(), permisos.getModulo(), permisos.getTipo_permiso() });
	}

	@Override
	public List<Permisos> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Permisos.class));
	}

	@Override
	public int update(int id, Permisos permisos) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { permisos.getId(), permisos.getPerfil(), permisos.getModulo(), permisos.getTipo_permiso(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
