package org.usco.agro.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProveedorRepository implements ProveedorRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.proveedor"
		+ "(empresa_id, fecha_creacion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, empresa_id, fecha_creacion, estado"
		+ " FROM public.proveedor";

	String UPDATE_SQL = "UPDATE public.proveedor"
		+ " SET empresa_id=?, fecha_creacion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.proveedor"
		+ " WHERE id=?";


	@Override
	public int create(Proveedor proveedor) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { proveedor.getEmpresa_id(), proveedor.getFecha_creacion(), proveedor.getEstado() });
	}

	@Override
	public List<Proveedor> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Proveedor.class));
	}

	@Override
	public int update(int id, Proveedor proveedor) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { proveedor.getEmpresa_id(), proveedor.getFecha_creacion(), proveedor.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
