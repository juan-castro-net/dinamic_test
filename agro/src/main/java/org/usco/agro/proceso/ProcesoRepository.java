package org.usco.agro.proceso;


import java.util.List;

public interface ProcesoRepository {
	
	public int create (Proceso proceso);
	
	public List<Proceso> read ();
	
	public int update (int id, Proceso proceso);
	
	public int delete (int id);

}
