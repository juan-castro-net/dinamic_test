package org.usco.pruebas.panelcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPanelcontrolRepository implements PanelcontrolRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.panelcontrol"
		+ "(nombre, descripcion, estado)"
		+ "VALUES (?, ?, ?)";

	String READ_SQL = "SELECT id, nombre, descripcion, estado"
		+ " FROM public.panelcontrol";

	String UPDATE_SQL = "UPDATE public.panelcontrol"
		+ " SET nombre=?, descripcion=?, estado=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.panelcontrol"
		+ " WHERE id=?";


	@Override
	public int create(Panelcontrol panelcontrol) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { panelcontrol.getId(), panelcontrol.getNombre(), panelcontrol.getDescripcion(), panelcontrol.getEstado() });
	}

	@Override
	public List<Panelcontrol> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Panelcontrol.class));
	}

	@Override
	public int update(int id, Panelcontrol panelcontrol) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { panelcontrol.getId(), panelcontrol.getNombre(), panelcontrol.getDescripcion(), panelcontrol.getEstado(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
