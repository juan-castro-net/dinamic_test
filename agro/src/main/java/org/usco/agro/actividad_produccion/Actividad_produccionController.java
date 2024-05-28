package org.usco.agro.actividad_produccion;

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
public class Actividad_produccionController {

	@Autowired
	Actividad_produccionRepository actividad_produccionRepository;

	@PostMapping("/actividad_produccion")
	public ResponseEntity<String> createActividad_produccion(@RequestBody Actividad_produccion actividad_produccion) {
		try {
			actividad_produccionRepository.create(
					new Actividad_produccion(actividad_produccion.getNombre(), actividad_produccion.getActividad_programacion_id(), actividad_produccion.getDescripcion(), actividad_produccion.getEstado()));
			return new ResponseEntity<>("Actividad_produccion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/actividad_produccion")
	public ResponseEntity<List<Actividad_produccion>> getAllActividad_produccions() {
		try {
			ArrayList<Actividad_produccion> actividad_produccions = new ArrayList<Actividad_produccion>();

			actividad_produccionRepository.read().forEach(actividad_produccions::add);

			if (actividad_produccions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(actividad_produccions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actividad_produccion/{id}")
	public ResponseEntity<String> updateActividad_produccion(@PathVariable("id") int id,
			@RequestBody Actividad_produccion actividad_produccion) {
		try {
			actividad_produccionRepository.update(id,
					new Actividad_produccion(actividad_produccion.getNombre(), actividad_produccion.getActividad_programacion_id(), actividad_produccion.getDescripcion(), actividad_produccion.getEstado()));
			return new ResponseEntity<>("Actividad_produccion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/actividad_produccion/{id}")
	public ResponseEntity<String> deleteActividad_produccion(@PathVariable("id") int id) {
		try {
			actividad_produccionRepository.delete(id);
			return new ResponseEntity<>("Actividad_produccion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
