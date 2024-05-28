package org.usco.agro.bloque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcBloqueRepository implements BloqueRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.bloque"
		+ "(sede_id, tipo_bloque_id, nombre, geolocalizacion, coordenadas, numero_pisos, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, sede_id, tipo_bloque_id, nombre, geolocalizacion, coordenadas, numero_pisos, descripcion, estado"
		+ " FROM public.bloque";

	String UPDATE_SQL = "UPDATE public.bloque"
		+ " SET sede_id=?, tipo_bloque_id=?, nombre=?, geolocalizacion=?, coordenadas=?, numero_pisos=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.bloque"
		+ " WHERE id=?";


	@Override
	public int create(Bloque bloque) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { bloque.getSede_id(), bloque.getTipo_bloque_id(), bloque.getNombre(), bloque.getGeolocalizacion(), bloque.getCoordenadas(), bloque.getNumero_pisos(), bloque.getDescripcion(), bloque.getEstado() });
	}

	@Override
	public List<Bloque> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Bloque.class));
	}

	@Override
	public int update(int id, Bloque bloque) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { bloque.getSede_id(), bloque.getTipo_bloque_id(), bloque.getNombre(), bloque.getGeolocalizacion(), bloque.getCoordenadas(), bloque.getNumero_pisos(), bloque.getDescripcion(), bloque.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
