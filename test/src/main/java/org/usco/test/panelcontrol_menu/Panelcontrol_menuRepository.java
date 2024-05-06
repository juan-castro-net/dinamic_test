package org.usco.test.panelcontrol_menu;


import java.util.List;

public interface Panelcontrol_menuRepository {
	
	public int create (Panelcontrol_menu panelcontrol_menu);
	
	public List<Panelcontrol_menu> read ();
	
	public int update (int id, Panelcontrol_menu panelcontrol_menu);
	
	public int delete (int id);

}
