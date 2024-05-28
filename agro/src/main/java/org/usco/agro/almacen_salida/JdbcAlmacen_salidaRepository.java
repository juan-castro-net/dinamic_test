package org.usco.agro.almacen_salida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAlmacen_salidaRepository implements Almacen_salidaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.almacen_salida"
		+ "(fecha, empresa_id, almacen_id, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, fecha, empresa_id, almacen_id, descripcion, estado"
		+ " FROM public.almacen_salida";

	String UPDATE_SQL = "UPDATE public.almacen_salida"
		+ " SET fecha=?, empresa_id=?, almacen_id=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.almacen_salida"
		+ " WHERE id=?";


	@Override
	public int create(Almacen_salida almacen_salida) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { almacen_salida.getFecha(), almacen_salida.getEmpresa_id(), almacen_salida.getAlmacen_id(), almacen_salida.getDescripcion(), almacen_salida.getEstado() });
	}

	@Override
	public List<Almacen_salida> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Almacen_salida.class));
	}

	@Override
	public int update(int id, Almacen_salida almacen_salida) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { almacen_salida.getFecha(), almacen_salida.getEmpresa_id(), almacen_salida.getAlmacen_id(), almacen_salida.getDescripcion(), almacen_salida.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
