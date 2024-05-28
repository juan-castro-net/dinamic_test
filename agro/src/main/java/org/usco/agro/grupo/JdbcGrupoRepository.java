package org.usco.agro.grupo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcGrupoRepository implements GrupoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.grupo"
		+ "(nombre, empresa_id, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, empresa_id, descripcion, estado"
		+ " FROM public.grupo";

	String UPDATE_SQL = "UPDATE public.grupo"
		+ " SET nombre=?, empresa_id=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.grupo"
		+ " WHERE id=?";


	@Override
	public int create(Grupo grupo) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { grupo.getNombre(), grupo.getEmpresa_id(), grupo.getDescripcion(), grupo.getEstado() });
	}

	@Override
	public List<Grupo> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Grupo.class));
	}

	@Override
	public int update(int id, Grupo grupo) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { grupo.getNombre(), grupo.getEmpresa_id(), grupo.getDescripcion(), grupo.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
