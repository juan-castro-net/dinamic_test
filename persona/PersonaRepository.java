package org.usco.test.persona;


import java.util.List;
/**
 * Interfaz para el repositorio de Persona que define las operaciones CRUD.
 */
public interface PersonaRepository {
	
    /**
     * Crea una nueva persona en el repositorio.
     *
     * @param persona La instancia de Persona a ser creada.
     * @return El ID de la persona creada o -1 si la operación falló.
     */
	public int create (Persona persona);
	
    /**
     * Lee y retorna todas las personas existentes en el repositorio.
     *
     * @return Una lista de todas las personas; puede estar vacía si no hay personas.
     */
	public List<Persona> read ();
	
    /**
     * Actualiza la información de una persona existente basada en su ID.
     *
     * @param id El ID de la persona a actualizar.
     * @param persona Una instancia de Persona con la información actualizada.
     * @return Un entero indicando el resultado de la operación (por ejemplo, 0 para fallo y 1 para éxito).
     */
	public int update (int id, Persona persona);
	
    /**
     * Elimina una persona del repositorio basado en su ID.
     *
     * @param id El ID de la persona a eliminar.
     * @return Un entero que indica el resultado de la operación (por ejemplo, 0 para fallo y 1 para éxito).
     */
	public int delete (int id);

}

