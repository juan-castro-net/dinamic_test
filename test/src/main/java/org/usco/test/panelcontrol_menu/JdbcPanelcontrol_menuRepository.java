package org.usco.test.panelcontrol_menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPanelcontrol_menuRepository implements Panelcontrol_menuRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = "INSERT INTO public.panelcontrol_menu"
		+ "(nombre)"
		+ "VALUES (?)";

	String READ_SQL = "SELECT id, nombre"
		+ " FROM public.panelcontrol_menu";

	String UPDATE_SQL = "UPDATE public.panelcontrol_menu"
		+ " SET nombre=?"
		+ " WHERE id=?";

	String DELETE_SQL = "DELETE FROM public.panelcontrol_menu"
		+ " WHERE id=?";


	@Override
	public int create(Panelcontrol_menu panelcontrol_menu) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { panelcontrol_menu.getNombre() });
	}

	@Override
	public List<Panelcontrol_menu> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance(Panelcontrol_menu.class));
	}

	@Override
	public int update(int id, Panelcontrol_menu panelcontrol_menu) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { panelcontrol_menu.getNombre(), id });
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(DELETE_SQL, id);
	}

}
