package org.usco.pruebas.usuario_perfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUsuario_perfilRepository implements Usuario_perfilRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.usuario_perfil"
		+ "(usuario, perfil, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, usuario, perfil, estado"
		+ " FROM public.usuario_perfil";

	String UPDATE_SQL = "UPDATE public.usuario_perfil"
		+ " SET usuario=?, perfil=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.usuario_perfil"
		+ " WHERE id=?";


	@Override
	public int create(Usuario_perfil usuario_perfil) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { usuario_perfil.getId(), usuario_perfil.getUsuario(), usuario_perfil.getPerfil(), usuario_perfil.getEstado() });
	}

	@Override
	public List<Usuario_perfil> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Usuario_perfil.class));
	}

	@Override
	public int update(int id, Usuario_perfil usuario_perfil) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { usuario_perfil.getId(), usuario_perfil.getUsuario(), usuario_perfil.getPerfil(), usuario_perfil.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
