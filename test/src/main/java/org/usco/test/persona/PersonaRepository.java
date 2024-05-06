package org.usco.test.persona;


import java.util.List;

public interface PersonaRepository {
	
	public int create (Persona persona);
	
	public List<Persona> read ();
	
	public int update (int id, Persona persona);
	
	public int delete (int id);

}
