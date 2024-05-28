package org.usco.agro.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProductoRepository implements ProductoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.producto"
		+ "(nombre, producto_categoria_id)"
		+ "VALUES (?, ?)";

	String READ_SQL = "SELECT id, nombre, producto_categoria_id"
		+ " FROM public.producto";

	String UPDATE_SQL = "UPDATE public.producto"
		+ " SET nombre=?, producto_categoria_id=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.producto"
		+ " WHERE id=?";


	@Override
	public int create(Producto producto) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { producto.getNombre(), producto.getProducto_categoria_id() });
	}

	@Override
	public List<Producto> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Producto.class));
	}

	@Override
	public int update(int id, Producto producto) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { producto.getNombre(), producto.getProducto_categoria_id(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
