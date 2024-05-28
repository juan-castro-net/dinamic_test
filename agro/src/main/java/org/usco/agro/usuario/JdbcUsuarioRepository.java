package org.usco.agro.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUsuarioRepository implements UsuarioRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.usuario"
		+ "(persona_id, email, password, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, persona_id, email, password, estado"
		+ " FROM public.usuario";

	String UPDATE_SQL = "UPDATE public.usuario"
		+ " SET persona_id=?, email=?, password=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.usuario"
		+ " WHERE id=?";


	@Override
	public int create(Usuario usuario) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { usuario.getPersona_id(), usuario.getEmail(), usuario.getPassword(), usuario.getEstado() });
	}

	@Override
	public List<Usuario> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Usuario.class));
	}

	@Override
	public int update(int id, Usuario usuario) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { usuario.getPersona_id(), usuario.getEmail(), usuario.getPassword(), usuario.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
