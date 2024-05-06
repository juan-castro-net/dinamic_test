package org.usco.test.persona;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para gestionar personas.
 * Permite crear, obtener, actualizar y eliminar personas en el sistema.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	PersonaRepository personaRepository;
    /**
     * Crea una nueva persona y la agrega al repositorio.
     * 
     * @param persona Objeto Persona con los datos a crear.
     * @return ResponseEntity con el estado de la operación.
     */

	@PostMapping("/persona")
	public ResponseEntity<String> createPersona(@RequestBody Persona persona) {
		try {
			personaRepository.create(
					new Persona(persona.getNombre(), persona.getApellido(), persona.getTipo_identificacion(), persona.getNum_identificacion(), persona.getGenero(), persona.getFecha_nacimiento(), persona.getEmail(), persona.getDireccion(), persona.getCelular(), persona.getEstado()));
			return new ResponseEntity<>("Persona creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    /**
     * Obtiene y devuelve todas las personas existentes en el repositorio.
     * 
     * @return ResponseEntity que contiene una lista de personas.
     */
	@GetMapping("/persona")
	public ResponseEntity<List<Persona>> getAllPersonas() {
		try {
			ArrayList<Persona> personas = new ArrayList<Persona>();

			personaRepository.read().forEach(personas::add);

			if (personas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(personas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
    /**
     * Actualiza la información de una persona existente basado en su ID.
     * 
     * @param id El ID de la persona a actualizar.
     * @param persona Objeto Persona con la información actualizada.
     * @return ResponseEntity con el estado de la operación.
     */
	@PutMapping("/persona/{id}")
	public ResponseEntity<String> updatePersona(@PathVariable("id") int id,
			@RequestBody Persona persona) {
		try {
			personaRepository.update(id,
					new Persona(persona.getNombre(), persona.getApellido(), persona.getTipo_identificacion(), persona.getNum_identificacion(), persona.getGenero(), persona.getFecha_nacimiento(), persona.getEmail(), persona.getDireccion(), persona.getCelular(), persona.getEstado()));
			return new ResponseEntity<>("Persona actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
    /**
     * Elimina una persona del repositorio basado en su ID.
     * 
     * @param id El ID de la persona a eliminar.
     * @return ResponseEntity con el estado de la operación.
     */
	@DeleteMapping("/persona/{id}")
	public ResponseEntity<String> deletePersona(@PathVariable("id") int id) {
		try {
			personaRepository.delete(id);
			return new ResponseEntity<>("Persona eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}