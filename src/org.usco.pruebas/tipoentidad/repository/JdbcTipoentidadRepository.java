package org.usco.pruebas.tipoentidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTipoentidadRepository implements TipoentidadRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.tipoentidad"
		+ "(nombre, estado)"
		+ "VALUES (?, ?)";

	String READ_SQL = "SELECT id, nombre, estado"
		+ " FROM public.tipoentidad";

	String UPDATE_SQL = "UPDATE public.tipoentidad"
		+ " SET nombre=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.tipoentidad"
		+ " WHERE id=?";


	@Override
	public int create(Tipoentidad tipoentidad) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { tipoentidad.getId(), tipoentidad.getNombre(), tipoentidad.getEstado() });
	}

	@Override
	public List<Tipoentidad> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Tipoentidad.class));
	}

	@Override
	public int update(int id, Tipoentidad tipoentidad) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { tipoentidad.getId(), tipoentidad.getNombre(), tipoentidad.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
