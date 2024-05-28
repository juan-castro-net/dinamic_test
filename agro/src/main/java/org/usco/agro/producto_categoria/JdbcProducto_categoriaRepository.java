package org.usco.agro.producto_categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProducto_categoriaRepository implements Producto_categoriaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.producto_categoria"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.producto_categoria";

	String UPDATE_SQL = "UPDATE public.producto_categoria"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.producto_categoria"
		+ " WHERE id=?";


	@Override
	public int create(Producto_categoria producto_categoria) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { producto_categoria.getNombre(), producto_categoria.getDescripcion(), producto_categoria.getEstado() });
	}

	@Override
	public List<Producto_categoria> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Producto_categoria.class));
	}

	@Override
	public int update(int id, Producto_categoria producto_categoria) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { producto_categoria.getNombre(), producto_categoria.getDescripcion(), producto_categoria.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
