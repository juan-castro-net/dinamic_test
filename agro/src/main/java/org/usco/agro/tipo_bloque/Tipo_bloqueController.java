package org.usco.agro.tipo_bloque;

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
public class Tipo_bloqueController {

	@Autowired
	Tipo_bloqueRepository tipo_bloqueRepository;

	@PostMapping("/tipo_bloque")
	public ResponseEntity<String> createTipo_bloque(@RequestBody Tipo_bloque tipo_bloque) {
		try {
			tipo_bloqueRepository.create(
					new Tipo_bloque(tipo_bloque.getNombre(), tipo_bloque.getDescripcion(), tipo_bloque.getEstado()));
			return new ResponseEntity<>("Tipo_bloque creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_bloque")
	public ResponseEntity<List<Tipo_bloque>> getAllTipo_bloques() {
		try {
			ArrayList<Tipo_bloque> tipo_bloques = new ArrayList<Tipo_bloque>();

			tipo_bloqueRepository.read().forEach(tipo_bloques::add);

			if (tipo_bloques.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_bloques, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_bloque/{id}")
	public ResponseEntity<String> updateTipo_bloque(@PathVariable("id") int id,
			@RequestBody Tipo_bloque tipo_bloque) {
		try {
			tipo_bloqueRepository.update(id,
					new Tipo_bloque(tipo_bloque.getNombre(), tipo_bloque.getDescripcion(), tipo_bloque.getEstado()));
			return new ResponseEntity<>("Tipo_bloque actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_bloque/{id}")
	public ResponseEntity<String> deleteTipo_bloque(@PathVariable("id") int id) {
		try {
			tipo_bloqueRepository.delete(id);
			return new ResponseEntity<>("Tipo_bloque eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
