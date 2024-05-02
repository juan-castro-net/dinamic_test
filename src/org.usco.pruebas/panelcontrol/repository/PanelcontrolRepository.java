package org.usco.pruebas.panelcontrol;


import java.util.List;

public interface PanelcontrolRepository {
	
	public int create (Panelcontrol panelcontrol);
	
	public List<Panelcontrol> read ();
	
	public int update (int id, Panelcontrol panelcontrol);
	
	public int delete (int id);

}
