package org.usco.test.usuario_perfil;


import java.util.List;

public interface Usuario_perfilRepository {
	
	public int create (Usuario_perfil usuario_perfil);
	
	public List<Usuario_perfil> read ();
	
	public int update (int id, Usuario_perfil usuario_perfil);
	
	public int delete (int id);

}
