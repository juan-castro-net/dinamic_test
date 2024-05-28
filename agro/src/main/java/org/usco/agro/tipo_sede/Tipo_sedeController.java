package org.usco.agro.tipo_sede;

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
public class Tipo_sedeController {

	@Autowired
	Tipo_sedeRepository tipo_sedeRepository;

	@PostMapping("/tipo_sede")
	public ResponseEntity<String> createTipo_sede(@RequestBody Tipo_sede tipo_sede) {
		try {
			tipo_sedeRepository.create(
					new Tipo_sede(tipo_sede.getNombre(), tipo_sede.getDescripcion(), tipo_sede.getEstado()));
			return new ResponseEntity<>("Tipo_sede creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_sede")
	public ResponseEntity<List<Tipo_sede>> getAllTipo_sedes() {
		try {
			ArrayList<Tipo_sede> tipo_sedes = new ArrayList<Tipo_sede>();

			tipo_sedeRepository.read().forEach(tipo_sedes::add);

			if (tipo_sedes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_sedes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_sede/{id}")
	public ResponseEntity<String> updateTipo_sede(@PathVariable("id") int id,
			@RequestBody Tipo_sede tipo_sede) {
		try {
			tipo_sedeRepository.update(id,
					new Tipo_sede(tipo_sede.getNombre(), tipo_sede.getDescripcion(), tipo_sede.getEstado()));
			return new ResponseEntity<>("Tipo_sede actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_sede/{id}")
	public ResponseEntity<String> deleteTipo_sede(@PathVariable("id") int id) {
		try {
			tipo_sedeRepository.delete(id);
			return new ResponseEntity<>("Tipo_sede eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
