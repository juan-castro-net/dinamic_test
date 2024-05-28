package org.usco.agro.costo_indirecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCosto_indirectoRepository implements Costo_indirectoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.costo_indirecto"
		+ "(espacio_id, tipo_costo_indirecto_id, fecha_inicio, fecha_fin, nombre, precio, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, espacio_id, tipo_costo_indirecto_id, fecha_inicio, fecha_fin, nombre, precio, descripcion, estado"
		+ " FROM public.costo_indirecto";

	String UPDATE_SQL = "UPDATE public.costo_indirecto"
		+ " SET espacio_id=?, tipo_costo_indirecto_id=?, fecha_inicio=?, fecha_fin=?, nombre=?, precio=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.costo_indirecto"
		+ " WHERE id=?";


	@Override
	public int create(Costo_indirecto costo_indirecto) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { costo_indirecto.getEspacio_id(), costo_indirecto.getTipo_costo_indirecto_id(), costo_indirecto.getFecha_inicio(), costo_indirecto.getFecha_fin(), costo_indirecto.getNombre(), costo_indirecto.getPrecio(), costo_indirecto.getDescripcion(), costo_indirecto.getEstado() });
	}

	@Override
	public List<Costo_indirecto> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Costo_indirecto.class));
	}

	@Override
	public int update(int id, Costo_indirecto costo_indirecto) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { costo_indirecto.getEspacio_id(), costo_indirecto.getTipo_costo_indirecto_id(), costo_indirecto.getFecha_inicio(), costo_indirecto.getFecha_fin(), costo_indirecto.getNombre(), costo_indirecto.getPrecio(), costo_indirecto.getDescripcion(), costo_indirecto.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
