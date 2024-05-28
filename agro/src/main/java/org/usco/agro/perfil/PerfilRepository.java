package org.usco.agro.perfil;


import java.util.List;

public interface PerfilRepository {
	
	public int create (Perfil perfil);
	
	public List<Perfil> read ();
	
	public int update (int id, Perfil perfil);
	
	public int delete (int id);

}
