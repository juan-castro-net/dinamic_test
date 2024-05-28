package org.usco.agro.empresa;


import java.util.List;

public interface EmpresaRepository {
	
	public int create (Empresa empresa);
	
	public List<Empresa> read ();
	
	public int update (int id, Empresa empresa);
	
	public int delete (int id);

}
