package org.usco.pruebas.municipio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcMunicipioRepository implements MunicipioRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.municipio"
		+ "(nombre, departamento, codigo, acronimo)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, departamento, codigo, acronimo"
		+ " FROM public.municipio";

	String UPDATE_SQL = "UPDATE public.municipio"
		+ " SET nombre=?, departamento=?, codigo=?, acronimo=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.municipio"
		+ " WHERE id=?";


	@Override
	public int create(Municipio municipio) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { municipio.getId(), municipio.getNombre(), municipio.getDepartamento(), municipio.getCodigo(), municipio.getAcronimo() });
	}

	@Override
	public List<Municipio> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Municipio.class));
	}

	@Override
	public int update(int id, Municipio municipio) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { municipio.getId(), municipio.getNombre(), municipio.getDepartamento(), municipio.getCodigo(), municipio.getAcronimo(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
