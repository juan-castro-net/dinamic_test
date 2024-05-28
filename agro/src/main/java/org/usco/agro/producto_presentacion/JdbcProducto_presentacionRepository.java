package org.usco.agro.producto_presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProducto_presentacionRepository implements Producto_presentacionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.producto_presentacion"
		+ "(producto_id, nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?)";

	String READ_SQL = "SELECT id, producto_id, nombre, descripcion, estado"
		+ " FROM public.producto_presentacion";

	String UPDATE_SQL = "UPDATE public.producto_presentacion"
		+ " SET producto_id=?, nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.producto_presentacion"
		+ " WHERE id=?";


	@Override
	public int create(Producto_presentacion producto_presentacion) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { producto_presentacion.getProducto_id(), producto_presentacion.getNombre(), producto_presentacion.getDescripcion(), producto_presentacion.getEstado() });
	}

	@Override
	public List<Producto_presentacion> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Producto_presentacion.class));
	}

	@Override
	public int update(int id, Producto_presentacion producto_presentacion) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { producto_presentacion.getProducto_id(), producto_presentacion.getNombre(), producto_presentacion.getDescripcion(), producto_presentacion.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
