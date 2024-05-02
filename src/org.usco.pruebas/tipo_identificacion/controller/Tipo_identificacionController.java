package org.usco.pruebas.tipo_identificacion;

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
public class Tipo_identificacionController {

	@Autowired
	Tipo_identificacionRepository tipo_identificacionRepository;

	@PostMapping("/tipo_identificacion")
	public ResponseEntity<String> createTipo_identificacion(@RequestBody Tipo_identificacion tipo_identificacion) {
		try {
			tipo_identificacionRepository.create(
					new Tipo_identificacion(tipo_identificacion.getNombre()));
			return new ResponseEntity<>("Tipo_identificacion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_identificacion")
	public ResponseEntity<List<Tipo_identificacion>> getAllTipo_identificacions() {
		try {
			ArrayList<Tipo_identificacion> tipo_identificacions = new ArrayList<Tipo_identificacion>();

			tipo_identificacionRepository.read().forEach(tipo_identificacions::add);

			if (tipo_identificacions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_identificacions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_identificacion/{id}")
	public ResponseEntity<String> updateTipo_identificacion(@PathVariable("id") int id,
			@RequestBody Tipo_identificacion tipo_identificacion) {
		try {
			tipo_identificacionRepository.update(id,
					new Tipo_identificacion(tipo_identificacion.getNombre()));
			return new ResponseEntity<>("Tipo_identificacion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_identificacion/{id}")
	public ResponseEntity<String> deleteTipo_identificacion(@PathVariable("id") int id) {
		try {
			tipo_identificacionRepository.delete(id);
			return new ResponseEntity<>("Tipo_identificacion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
