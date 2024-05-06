package org.usco.test.sesion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSesionRepository implements SesionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.sesion"
		+ "(usuario, fecha_hora_start, fecha_hora_end, ip)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, usuario, fecha_hora_start, fecha_hora_end, ip"
		+ " FROM public.sesion";

	String UPDATE_SQL = "UPDATE public.sesion"
		+ " SET usuario=?, fecha_hora_start=?, fecha_hora_end=?, ip=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.sesion"
		+ " WHERE id=?";


	@Override
	public int create(Sesion sesion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { sesion.getUsuario(), sesion.getFecha_hora_start(), sesion.getFecha_hora_end(), sesion.getIp() });
	}

	@Override
	public List<Sesion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Sesion.class));
	}

	@Override
	public int update(int id, Sesion sesion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { sesion.getUsuario(), sesion.getFecha_hora_start(), sesion.getFecha_hora_end(), sesion.getIp(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
