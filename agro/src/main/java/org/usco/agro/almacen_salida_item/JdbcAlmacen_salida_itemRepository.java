package org.usco.agro.almacen_salida_item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAlmacen_salida_itemRepository implements Almacen_salida_itemRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.almacen_salida_item"
		+ "(almacen_salida_id, producto_id, producto_presentacion_id, cantidad, precio, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, almacen_salida_id, producto_id, producto_presentacion_id, cantidad, precio, estado"
		+ " FROM public.almacen_salida_item";

	String UPDATE_SQL = "UPDATE public.almacen_salida_item"
		+ " SET almacen_salida_id=?, producto_id=?, producto_presentacion_id=?, cantidad=?, precio=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.almacen_salida_item"
		+ " WHERE id=?";


	@Override
	public int create(Almacen_salida_item almacen_salida_item) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { almacen_salida_item.getAlmacen_salida_id(), almacen_salida_item.getProducto_id(), almacen_salida_item.getProducto_presentacion_id(), almacen_salida_item.getCantidad(), almacen_salida_item.getPrecio(), almacen_salida_item.getEstado() });
	}

	@Override
	public List<Almacen_salida_item> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Almacen_salida_item.class));
	}

	@Override
	public int update(int id, Almacen_salida_item almacen_salida_item) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { almacen_salida_item.getAlmacen_salida_id(), almacen_salida_item.getProducto_id(), almacen_salida_item.getProducto_presentacion_id(), almacen_salida_item.getCantidad(), almacen_salida_item.getPrecio(), almacen_salida_item.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
