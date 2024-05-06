package org.usco.test.permisos;

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
public class PermisosController {

	@Autowired
	PermisosRepository permisosRepository;

	@PostMapping("/permisos")
	public ResponseEntity<String> createPermisos(@RequestBody Permisos permisos) {
		try {
			permisosRepository.create(
					new Permisos(permisos.getPerfil(), permisos.getModulo(), permisos.getTipo_permiso()));
			return new ResponseEntity<>("Permisos creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/permisos")
	public ResponseEntity<List<Permisos>> getAllPermisoss() {
		try {
			ArrayList<Permisos> permisoss = new ArrayList<Permisos>();

			permisosRepository.read().forEach(permisoss::add);

			if (permisoss.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(permisoss, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/permisos/{id}")
	public ResponseEntity<String> updatePermisos(@PathVariable("id") int id,
			@RequestBody Permisos permisos) {
		try {
			permisosRepository.update(id,
					new Permisos(permisos.getPerfil(), permisos.getModulo(), permisos.getTipo_permiso()));
			return new ResponseEntity<>("Permisos actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/permisos/{id}")
	public ResponseEntity<String> deletePermisos(@PathVariable("id") int id) {
		try {
			permisosRepository.delete(id);
			return new ResponseEntity<>("Permisos eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
