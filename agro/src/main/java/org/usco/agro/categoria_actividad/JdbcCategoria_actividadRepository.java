package org.usco.agro.categoria_actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCategoria_actividadRepository implements Categoria_actividadRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.categoria_actividad"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.categoria_actividad";

	String UPDATE_SQL = "UPDATE public.categoria_actividad"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.categoria_actividad"
		+ " WHERE id=?";


	@Override
	public int create(Categoria_actividad categoria_actividad) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { categoria_actividad.getNombre(), categoria_actividad.getDescripcion(), categoria_actividad.getEstado() });
	}

	@Override
	public List<Categoria_actividad> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Categoria_actividad.class));
	}

	@Override
	public int update(int id, Categoria_actividad categoria_actividad) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { categoria_actividad.getNombre(), categoria_actividad.getDescripcion(), categoria_actividad.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
