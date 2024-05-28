package org.usco.agro.modulo_metodo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcModulo_metodoRepository implements Modulo_metodoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.modulo_metodo"
		+ "(modulo_id, metodo_id, uri, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, modulo_id, metodo_id, uri, estado"
		+ " FROM public.modulo_metodo";

	String UPDATE_SQL = "UPDATE public.modulo_metodo"
		+ " SET modulo_id=?, metodo_id=?, uri=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.modulo_metodo"
		+ " WHERE id=?";


	@Override
	public int create(Modulo_metodo modulo_metodo) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { modulo_metodo.getModulo_id(), modulo_metodo.getMetodo_id(), modulo_metodo.getUri(), modulo_metodo.getEstado() });
	}

	@Override
	public List<Modulo_metodo> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Modulo_metodo.class));
	}

	@Override
	public int update(int id, Modulo_metodo modulo_metodo) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { modulo_metodo.getModulo_id(), modulo_metodo.getMetodo_id(), modulo_metodo.getUri(), modulo_metodo.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
