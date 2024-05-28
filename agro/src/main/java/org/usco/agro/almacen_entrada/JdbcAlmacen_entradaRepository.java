package org.usco.agro.almacen_entrada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAlmacen_entradaRepository implements Almacen_entradaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.almacen_entrada"
		+ "(proveedor_id, fecha, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, proveedor_id, fecha, descripcion, estado"
		+ " FROM public.almacen_entrada";

	String UPDATE_SQL = "UPDATE public.almacen_entrada"
		+ " SET proveedor_id=?, fecha=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.almacen_entrada"
		+ " WHERE id=?";


	@Override
	public int create(Almacen_entrada almacen_entrada) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { almacen_entrada.getProveedor_id(), almacen_entrada.getFecha(), almacen_entrada.getDescripcion(), almacen_entrada.getEstado() });
	}

	@Override
	public List<Almacen_entrada> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Almacen_entrada.class));
	}

	@Override
	public int update(int id, Almacen_entrada almacen_entrada) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { almacen_entrada.getProveedor_id(), almacen_entrada.getFecha(), almacen_entrada.getDescripcion(), almacen_entrada.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
