package org.usco.test.tipo_permiso;

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
public class Tipo_permisoController {

	@Autowired
	Tipo_permisoRepository tipo_permisoRepository;

	@PostMapping("/tipo_permiso")
	public ResponseEntity<String> createTipo_permiso(@RequestBody Tipo_permiso tipo_permiso) {
		try {
			tipo_permisoRepository.create(
					new Tipo_permiso(tipo_permiso.getNombre()));
			return new ResponseEntity<>("Tipo_permiso creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_permiso")
	public ResponseEntity<List<Tipo_permiso>> getAllTipo_permisos() {
		try {
			ArrayList<Tipo_permiso> tipo_permisos = new ArrayList<Tipo_permiso>();

			tipo_permisoRepository.read().forEach(tipo_permisos::add);

			if (tipo_permisos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_permisos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_permiso/{id}")
	public ResponseEntity<String> updateTipo_permiso(@PathVariable("id") int id,
			@RequestBody Tipo_permiso tipo_permiso) {
		try {
			tipo_permisoRepository.update(id,
					new Tipo_permiso(tipo_permiso.getNombre()));
			return new ResponseEntity<>("Tipo_permiso actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_permiso/{id}")
	public ResponseEntity<String> deleteTipo_permiso(@PathVariable("id") int id) {
		try {
			tipo_permisoRepository.delete(id);
			return new ResponseEntity<>("Tipo_permiso eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
