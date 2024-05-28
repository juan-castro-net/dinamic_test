package org.usco.agro.modulo_metodo;

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
public class Modulo_metodoController {

	@Autowired
	Modulo_metodoRepository modulo_metodoRepository;

	@PostMapping("/modulo_metodo")
	public ResponseEntity<String> createModulo_metodo(@RequestBody Modulo_metodo modulo_metodo) {
		try {
			modulo_metodoRepository.create(
					new Modulo_metodo(modulo_metodo.getModulo_id(), modulo_metodo.getMetodo_id(), modulo_metodo.getUri(), modulo_metodo.getEstado()));
			return new ResponseEntity<>("Modulo_metodo creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/modulo_metodo")
	public ResponseEntity<List<Modulo_metodo>> getAllModulo_metodos() {
		try {
			ArrayList<Modulo_metodo> modulo_metodos = new ArrayList<Modulo_metodo>();

			modulo_metodoRepository.read().forEach(modulo_metodos::add);

			if (modulo_metodos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(modulo_metodos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modulo_metodo/{id}")
	public ResponseEntity<String> updateModulo_metodo(@PathVariable("id") int id,
			@RequestBody Modulo_metodo modulo_metodo) {
		try {
			modulo_metodoRepository.update(id,
					new Modulo_metodo(modulo_metodo.getModulo_id(), modulo_metodo.getMetodo_id(), modulo_metodo.getUri(), modulo_metodo.getEstado()));
			return new ResponseEntity<>("Modulo_metodo actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/modulo_metodo/{id}")
	public ResponseEntity<String> deleteModulo_metodo(@PathVariable("id") int id) {
		try {
			modulo_metodoRepository.delete(id);
			return new ResponseEntity<>("Modulo_metodo eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
