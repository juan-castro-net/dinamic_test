package org.usco.test.usuario;


import java.util.List;

public interface UsuarioRepository {
	
	public int create (Usuario usuario);
	
	public List<Usuario> read ();
	
	public int update (int id, Usuario usuario);
	
	public int delete (int id);

}
