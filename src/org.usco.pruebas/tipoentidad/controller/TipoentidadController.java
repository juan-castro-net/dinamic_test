package org.usco.pruebas.tipoentidad;

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
public class TipoentidadController {

	@Autowired
	TipoentidadRepository tipoentidadRepository;

	@PostMapping("/tipoentidad")
	public ResponseEntity<String> createTipoentidad(@RequestBody Tipoentidad tipoentidad) {
		try {
			tipoentidadRepository.create(
					new Tipoentidad(tipoentidad.getNombre(), tipoentidad.getEstado()));
			return new ResponseEntity<>("Tipoentidad creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipoentidad")
	public ResponseEntity<List<Tipoentidad>> getAllTipoentidads() {
		try {
			ArrayList<Tipoentidad> tipoentidads = new ArrayList<Tipoentidad>();

			tipoentidadRepository.read().forEach(tipoentidads::add);

			if (tipoentidads.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipoentidads, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipoentidad/{id}")
	public ResponseEntity<String> updateTipoentidad(@PathVariable("id") int id,
			@RequestBody Tipoentidad tipoentidad) {
		try {
			tipoentidadRepository.update(id,
					new Tipoentidad(tipoentidad.getNombre(), tipoentidad.getEstado()));
			return new ResponseEntity<>("Tipoentidad actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipoentidad/{id}")
	public ResponseEntity<String> deleteTipoentidad(@PathVariable("id") int id) {
		try {
			tipoentidadRepository.delete(id);
			return new ResponseEntity<>("Tipoentidad eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
