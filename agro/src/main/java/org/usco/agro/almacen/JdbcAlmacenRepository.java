package org.usco.agro.almacen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAlmacenRepository implements AlmacenRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.almacen"
		+ "(nombre, sede_id, geolocalizacion, coordenadas, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, sede_id, geolocalizacion, coordenadas, descripcion, estado"
		+ " FROM public.almacen";

	String UPDATE_SQL = "UPDATE public.almacen"
		+ " SET nombre=?, sede_id=?, geolocalizacion=?, coordenadas=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.almacen"
		+ " WHERE id=?";


	@Override
	public int create(Almacen almacen) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { almacen.getNombre(), almacen.getSede_id(), almacen.getGeolocalizacion(), almacen.getCoordenadas(), almacen.getDescripcion(), almacen.getEstado() });
	}

	@Override
	public List<Almacen> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Almacen.class));
	}

	@Override
	public int update(int id, Almacen almacen) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { almacen.getNombre(), almacen.getSede_id(), almacen.getGeolocalizacion(), almacen.getCoordenadas(), almacen.getDescripcion(), almacen.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
