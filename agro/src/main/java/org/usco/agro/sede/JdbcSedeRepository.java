package org.usco.agro.sede;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSedeRepository implements SedeRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.sede"
		+ "(grupo_id, tipo_sede_id, nombre, municipio_id, geolocalizacion, coordenadas, area, comuna, descripcion, estado)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, grupo_id, tipo_sede_id, nombre, municipio_id, geolocalizacion, coordenadas, area, comuna, descripcion, estado"
		+ " FROM public.sede";

	String UPDATE_SQL = "UPDATE public.sede"
		+ " SET grupo_id=?, tipo_sede_id=?, nombre=?, municipio_id=?, geolocalizacion=?, coordenadas=?, area=?, comuna=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.sede"
		+ " WHERE id=?";


	@Override
	public int create(Sede sede) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { sede.getGrupo_id(), sede.getTipo_sede_id(), sede.getNombre(), sede.getMunicipio_id(), sede.getGeolocalizacion(), sede.getCoordenadas(), sede.getArea(), sede.getComuna(), sede.getDescripcion(), sede.getEstado() });
	}

	@Override
	public List<Sede> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Sede.class));
	}

	@Override
	public int update(int id, Sede sede) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { sede.getGrupo_id(), sede.getTipo_sede_id(), sede.getNombre(), sede.getMunicipio_id(), sede.getGeolocalizacion(), sede.getCoordenadas(), sede.getArea(), sede.getComuna(), sede.getDescripcion(), sede.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
