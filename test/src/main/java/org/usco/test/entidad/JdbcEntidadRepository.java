package org.usco.test.entidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEntidadRepository implements EntidadRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.entidad"
		+ "(nombre, municipio, codigo, tipoentidad, estado, comuna, geolocalizacion)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, municipio, codigo, tipoentidad, estado, comuna, geolocalizacion"
		+ " FROM public.entidad";

	String UPDATE_SQL = "UPDATE public.entidad"
		+ " SET nombre=?, municipio=?, codigo=?, tipoentidad=?, estado=?, comuna=?, geolocalizacion=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.entidad"
		+ " WHERE id=?";


	@Override
	public int create(Entidad entidad) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { entidad.getNombre(), entidad.getMunicipio(), entidad.getCodigo(), entidad.getTipoentidad(), entidad.getEstado(), entidad.getComuna(), entidad.getGeolocalizacion() });
	}

	@Override
	public List<Entidad> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Entidad.class));
	}

	@Override
	public int update(int id, Entidad entidad) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { entidad.getNombre(), entidad.getMunicipio(), entidad.getCodigo(), entidad.getTipoentidad(), entidad.getEstado(), entidad.getComuna(), entidad.getGeolocalizacion(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
