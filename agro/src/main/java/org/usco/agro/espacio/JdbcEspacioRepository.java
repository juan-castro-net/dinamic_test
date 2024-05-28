package org.usco.agro.espacio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEspacioRepository implements EspacioRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.espacio"
		+ "(bloque_id, tipo_espacio_id, nombre, geolocalizacion, coordenadas, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, bloque_id, tipo_espacio_id, nombre, geolocalizacion, coordenadas, descripcion, estado"
		+ " FROM public.espacio";

	String UPDATE_SQL = "UPDATE public.espacio"
		+ " SET bloque_id=?, tipo_espacio_id=?, nombre=?, geolocalizacion=?, coordenadas=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.espacio"
		+ " WHERE id=?";


	@Override
	public int create(Espacio espacio) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { espacio.getBloque_id(), espacio.getTipo_espacio_id(), espacio.getNombre(), espacio.getGeolocalizacion(), espacio.getCoordenadas(), espacio.getDescripcion(), espacio.getEstado() });
	}

	@Override
	public List<Espacio> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Espacio.class));
	}

	@Override
	public int update(int id, Espacio espacio) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { espacio.getBloque_id(), espacio.getTipo_espacio_id(), espacio.getNombre(), espacio.getGeolocalizacion(), espacio.getCoordenadas(), espacio.getDescripcion(), espacio.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
