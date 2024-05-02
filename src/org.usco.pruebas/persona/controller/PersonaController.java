package org.usco.pruebas.persona;

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


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	PersonaRepository personaRepository;

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
