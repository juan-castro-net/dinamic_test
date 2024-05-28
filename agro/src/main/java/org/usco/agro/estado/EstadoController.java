package org.usco.agro.estado;

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
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;

	@PostMapping("/estado")
	public ResponseEntity<String> createEstado(@RequestBody Estado estado) {
		try {
			estadoRepository.create(
					new Estado(estado.getNombre(), estado.getDescripcion()));
			return new ResponseEntity<>("Estado creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/estado")
	public ResponseEntity<List<Estado>> getAllEstados() {
		try {
			ArrayList<Estado> estados = new ArrayList<Estado>();

			estadoRepository.read().forEach(estados::add);

			if (estados.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(estados, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/estado/{id}")
	public ResponseEntity<String> updateEstado(@PathVariable("id") int id,
			@RequestBody Estado estado) {
		try {
			estadoRepository.update(id,
					new Estado(estado.getNombre(), estado.getDescripcion()));
			return new ResponseEntity<>("Estado actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/estado/{id}")
	public ResponseEntity<String> deleteEstado(@PathVariable("id") int id) {
		try {
			estadoRepository.delete(id);
			return new ResponseEntity<>("Estado eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
