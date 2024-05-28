package org.usco.agro.almacen_entrada_item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAlmacen_entrada_itemRepository implements Almacen_entrada_itemRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.almacen_entrada_item"
		+ "(almacen_entrada_id, producto_id, producto_presentacion_id, cantidad, precio, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, almacen_entrada_id, producto_id, producto_presentacion_id, cantidad, precio, estado"
		+ " FROM public.almacen_entrada_item";

	String UPDATE_SQL = "UPDATE public.almacen_entrada_item"
		+ " SET almacen_entrada_id=?, producto_id=?, producto_presentacion_id=?, cantidad=?, precio=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.almacen_entrada_item"
		+ " WHERE id=?";


	@Override
	public int create(Almacen_entrada_item almacen_entrada_item) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { almacen_entrada_item.getAlmacen_entrada_id(), almacen_entrada_item.getProducto_id(), almacen_entrada_item.getProducto_presentacion_id(), almacen_entrada_item.getCantidad(), almacen_entrada_item.getPrecio(), almacen_entrada_item.getEstado() });
	}

	@Override
	public List<Almacen_entrada_item> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Almacen_entrada_item.class));
	}

	@Override
	public int update(int id, Almacen_entrada_item almacen_entrada_item) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { almacen_entrada_item.getAlmacen_entrada_id(), almacen_entrada_item.getProducto_id(), almacen_entrada_item.getProducto_presentacion_id(), almacen_entrada_item.getCantidad(), almacen_entrada_item.getPrecio(), almacen_entrada_item.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
