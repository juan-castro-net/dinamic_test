package org.usco.agro.tipo_espacio;

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
public class Tipo_espacioController {

	@Autowired
	Tipo_espacioRepository tipo_espacioRepository;

	@PostMapping("/tipo_espacio")
	public ResponseEntity<String> createTipo_espacio(@RequestBody Tipo_espacio tipo_espacio) {
		try {
			tipo_espacioRepository.create(
					new Tipo_espacio(tipo_espacio.getNombre(), tipo_espacio.getDescripcion(), tipo_espacio.getEstado()));
			return new ResponseEntity<>("Tipo_espacio creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_espacio")
	public ResponseEntity<List<Tipo_espacio>> getAllTipo_espacios() {
		try {
			ArrayList<Tipo_espacio> tipo_espacios = new ArrayList<Tipo_espacio>();

			tipo_espacioRepository.read().forEach(tipo_espacios::add);

			if (tipo_espacios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_espacios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_espacio/{id}")
	public ResponseEntity<String> updateTipo_espacio(@PathVariable("id") int id,
			@RequestBody Tipo_espacio tipo_espacio) {
		try {
			tipo_espacioRepository.update(id,
					new Tipo_espacio(tipo_espacio.getNombre(), tipo_espacio.getDescripcion(), tipo_espacio.getEstado()));
			return new ResponseEntity<>("Tipo_espacio actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_espacio/{id}")
	public ResponseEntity<String> deleteTipo_espacio(@PathVariable("id") int id) {
		try {
			tipo_espacioRepository.delete(id);
			return new ResponseEntity<>("Tipo_espacio eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
