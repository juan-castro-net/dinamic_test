package org.usco.agro.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEmpresaRepository implements EmpresaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.empresa"
		+ "(tipo_identificacion_id, identificacion, nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, tipo_identificacion_id, identificacion, nombre, descripcion, estado"
		+ " FROM public.empresa";

	String UPDATE_SQL = "UPDATE public.empresa"
		+ " SET tipo_identificacion_id=?, identificacion=?, nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.empresa"
		+ " WHERE id=?";


	@Override
	public int create(Empresa empresa) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { empresa.getTipo_identificacion_id(), empresa.getIdentificacion(), empresa.getNombre(), empresa.getDescripcion(), empresa.getEstado() });
	}

	@Override
	public List<Empresa> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Empresa.class));
	}

	@Override
	public int update(int id, Empresa empresa) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { empresa.getTipo_identificacion_id(), empresa.getIdentificacion(), empresa.getNombre(), empresa.getDescripcion(), empresa.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
