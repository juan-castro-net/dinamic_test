package org.usco.agro.grupo;


import java.util.List;

public interface GrupoRepository {
	
	public int create (Grupo grupo);
	
	public List<Grupo> read ();
	
	public int update (int id, Grupo grupo);
	
	public int delete (int id);

}
