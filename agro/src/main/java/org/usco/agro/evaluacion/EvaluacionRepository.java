package org.usco.agro.evaluacion;


import java.util.List;

public interface EvaluacionRepository {
	
	public int create (Evaluacion evaluacion);
	
	public List<Evaluacion> read ();
	
	public int update (int id, Evaluacion evaluacion);
	
	public int delete (int id);

}
