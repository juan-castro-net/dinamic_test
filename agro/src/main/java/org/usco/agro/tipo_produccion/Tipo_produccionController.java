package org.usco.agro.tipo_produccion;

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
public class Tipo_produccionController {

	@Autowired
	Tipo_produccionRepository tipo_produccionRepository;

	@PostMapping("/tipo_produccion")
	public ResponseEntity<String> createTipo_produccion(@RequestBody Tipo_produccion tipo_produccion) {
		try {
			tipo_produccionRepository.create(
					new Tipo_produccion(tipo_produccion.getNombre(), tipo_produccion.getDescripcion(), tipo_produccion.getEstado()));
			return new ResponseEntity<>("Tipo_produccion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_produccion")
	public ResponseEntity<List<Tipo_produccion>> getAllTipo_produccions() {
		try {
			ArrayList<Tipo_produccion> tipo_produccions = new ArrayList<Tipo_produccion>();

			tipo_produccionRepository.read().forEach(tipo_produccions::add);

			if (tipo_produccions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_produccions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_produccion/{id}")
	public ResponseEntity<String> updateTipo_produccion(@PathVariable("id") int id,
			@RequestBody Tipo_produccion tipo_produccion) {
		try {
			tipo_produccionRepository.update(id,
					new Tipo_produccion(tipo_produccion.getNombre(), tipo_produccion.getDescripcion(), tipo_produccion.getEstado()));
			return new ResponseEntity<>("Tipo_produccion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_produccion/{id}")
	public ResponseEntity<String> deleteTipo_produccion(@PathVariable("id") int id) {
		try {
			tipo_produccionRepository.delete(id);
			return new ResponseEntity<>("Tipo_produccion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
