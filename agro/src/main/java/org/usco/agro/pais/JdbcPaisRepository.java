package org.usco.agro.pais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPaisRepository implements PaisRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.pais"
		+ "(nombre, codigo, acronimo)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, codigo, acronimo"
		+ " FROM public.pais";

	String UPDATE_SQL = "UPDATE public.pais"
		+ " SET nombre=?, codigo=?, acronimo=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.pais"
		+ " WHERE id=?";


	@Override
	public int create(Pais pais) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { pais.getNombre(), pais.getCodigo(), pais.getAcronimo() });
	}

	@Override
	public List<Pais> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Pais.class));
	}

	@Override
	public int update(int id, Pais pais) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { pais.getNombre(), pais.getCodigo(), pais.getAcronimo(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
