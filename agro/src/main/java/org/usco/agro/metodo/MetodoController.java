package org.usco.agro.metodo;

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
public class MetodoController {

	@Autowired
	MetodoRepository metodoRepository;

	@PostMapping("/metodo")
	public ResponseEntity<String> createMetodo(@RequestBody Metodo metodo) {
		try {
			metodoRepository.create(
					new Metodo(metodo.getNombre(), metodo.getDescripcion(), metodo.getEstado()));
			return new ResponseEntity<>("Metodo creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/metodo")
	public ResponseEntity<List<Metodo>> getAllMetodos() {
		try {
			ArrayList<Metodo> metodos = new ArrayList<Metodo>();

			metodoRepository.read().forEach(metodos::add);

			if (metodos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(metodos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/metodo/{id}")
	public ResponseEntity<String> updateMetodo(@PathVariable("id") int id,
			@RequestBody Metodo metodo) {
		try {
			metodoRepository.update(id,
					new Metodo(metodo.getNombre(), metodo.getDescripcion(), metodo.getEstado()));
			return new ResponseEntity<>("Metodo actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/metodo/{id}")
	public ResponseEntity<String> deleteMetodo(@PathVariable("id") int id) {
		try {
			metodoRepository.delete(id);
			return new ResponseEntity<>("Metodo eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
