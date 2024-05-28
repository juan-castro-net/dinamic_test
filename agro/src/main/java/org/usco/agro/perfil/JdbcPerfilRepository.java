package org.usco.agro.perfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPerfilRepository implements PerfilRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.perfil"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.perfil";

	String UPDATE_SQL = "UPDATE public.perfil"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.perfil"
		+ " WHERE id=?";


	@Override
	public int create(Perfil perfil) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { perfil.getNombre(), perfil.getDescripcion(), perfil.getEstado() });
	}

	@Override
	public List<Perfil> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Perfil.class));
	}

	@Override
	public int update(int id, Perfil perfil) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { perfil.getNombre(), perfil.getDescripcion(), perfil.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
